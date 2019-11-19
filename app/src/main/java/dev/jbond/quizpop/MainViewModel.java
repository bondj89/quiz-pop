package dev.jbond.quizpop;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import dev.jbond.quizpop.model.entity.Answer;
import dev.jbond.quizpop.model.entity.Game;
import dev.jbond.quizpop.model.entity.Question;
import dev.jbond.quizpop.model.entity.Question.Type;
import dev.jbond.quizpop.model.pojo.QuestionWithAnswers;
import dev.jbond.quizpop.service.QuizPopDatabase;
import dev.jbond.quizpop.service.QuizPopService;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The type Main view model.
 */
public class MainViewModel extends AndroidViewModel {

  private static final int DEFAULT_NUMBER_OF_QUESTIONS = 25;

  private LiveData<List<Question>> randQuestionList;
//  private LiveData<QuestionWithAnswers> randomQuestion;
//  private MutableLiveData<Boolean> refreshRandom = new MutableLiveData<>(false);

  private ExecutorService executor;
  private QuizPopDatabase database;
  private MutableLiveData<Boolean> refreshRandom = new MutableLiveData<>();
  private MutableLiveData<Game> game = new MutableLiveData<>(null);


  /**
   * Instantiates a new Main view model.
   *
   * @param application the application
   */
  public MainViewModel(@NonNull Application application) {
    super(application);
    randQuestionList = new MutableLiveData<>();
    database = QuizPopDatabase.getInstance();
    executor = Executors.newSingleThreadExecutor();
    createRandomQuestion();
    getRandomQuestionFromDb();
  }

  /**
   * Gets game.
   *
   * @return the game
   */
  public LiveData<Game> getGame() {
    return game;
  }

  /**
   * Create random question.
   */
  public void createRandomQuestion() {
    QuizPopService.getInstance().randomQuestion(DEFAULT_NUMBER_OF_QUESTIONS)
        .subscribeOn(Schedulers.from(executor))
        .subscribe((response -> {
        }));
  }

  /**
   * Record result.
   * Increment the counts in the database.
   * @param correct the correct
   */

  // TODO: debug
  public void recordResult(boolean correct) {
    executor.submit(() -> {
      Game game = this.game.getValue();
      game.setTotal(game.getTotal() + 1);
      if (correct) {
        game.setScore(game.getScore() + 1);
      }
      database.getGameDao().update(game);
    });
  }

  /**
   *
   * New game.
   * Create a new game in the database.
   */

  public void newGame() {
    executor.submit(() -> {
      Game game = new Game();
      long id = database.getGameDao().insert(game);
      game.setId(id);
      this.game.postValue(game);
      refreshRandom();
    });
  }


  /**
   * Gets rand question list.
   *
   * @return the rand question list
   */
  public LiveData<List<Question>> getRandQuestionList() {

    return randQuestionList;
  }

  /**
   * Get random question live data.
   *
   * @return the live data
   */
  public LiveData<QuestionWithAnswers> getRandomQuestion(){

    return database.getQuestionDao().getRandom();

  }

  /**
   * Refresh random.
   */
  public void refreshRandom() {
//    refreshRandom.postValue(true);
      loadBatch();
//    database.getQuestionDao().count()
//        .subscribeOn(Schedulers.io())
//        .subscribe((count) -> {
//          if (count > 0) {
//            refreshRandom.postValue(true);
//          } else {
//            loadBatch();
//          }
//        });
  }

  private void loadBatch() {
    QuizPopService.getInstance().randomQuestion(10)
        .subscribeOn(Schedulers.from(executor))
        .subscribe((response) -> {
          database.runInTransaction(() -> {
            for (Question question : response.getQuestions()) {
              if (question.getType() == Type.BOOLEAN) {
                question.setCorrect(Boolean.valueOf(question.getTempCorrectAnswer()));
                database.getQuestionDao().insert(question);
              } else {
                List<Answer> answers = new LinkedList<>();
                Answer answer = new Answer();
                answer.setText(question.getTempCorrectAnswer());
                answer.setCorrect(true);
                answers.add(answer);
                for (String s : question.getTempIncorrectAnswers()) {
                  answer = new Answer();
                  answer.setText(s);
                  answer.setCorrect(false);
                  answers.add(answer);
                }
                long id = database.getQuestionDao().insert(question);
                if (id > 0) {
                  for (Answer a : answers) {
                    a.setQuestionId(id);
                  }
                  database.getAnswerDao().insert(answers);
                  //  refreshRandom.postValue(!refreshRandom.getValue());
                }
              }
            }
          });
        });
  }


  /**
   * Get rand question list size int.
   *
   * @return the int
   */
  public int getRandQuestionListSize(){
    return randQuestionList.getValue().size();
  }

  private void getRandomQuestionFromDb() {
    randQuestionList = database.getQuestionDao().getRandomAll();
  }

}
