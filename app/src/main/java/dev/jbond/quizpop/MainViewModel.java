package dev.jbond.quizpop;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import dev.jbond.quizpop.model.entity.Answer;
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

public class MainViewModel extends AndroidViewModel {

  private static final int DEFAULT_NUMBER_OF_QUESTIONS = 25;

  private LiveData<List<Question>> randQuestionList;
//  private LiveData<QuestionWithAnswers> randomQuestion;
//  private MutableLiveData<Boolean> refreshRandom = new MutableLiveData<>(false);

  private ExecutorService executor;
  private QuizPopDatabase database;

  public MainViewModel(@NonNull Application application) {
    super(application);
    randQuestionList = new MutableLiveData<>();
    database = QuizPopDatabase.getInstance();
    executor = Executors.newSingleThreadExecutor();
//    randomQuestion = database.getQuestionDao().getRandom();
//    randomQuestion = Transformations.switchMap(refreshRandom,
//        (ignoreBoolean) -> database.getQuestionDao().getRandom());
    createRandomQuestion();
    getRandomQuestionFromDb();
  }

  public void createRandomQuestion() {
    QuizPopService.getInstance().randomQuestion(DEFAULT_NUMBER_OF_QUESTIONS)
        .subscribeOn(Schedulers.from(executor))
        .subscribe((response -> {
        }));
  }


//  public void createRandomQuestion() {
//    QuizPopService.getInstance().randomQuestion(DEFAULT_NUMBER_OF_QUESTIONS)
//        .subscribeOn(Schedulers.from(executor))
//        .subscribe((response -> {
//          for (Question question : response.getQuestions()) {
//            if (question.getType() == Type.BOOLEAN) {
//              question.setCorrect(Boolean.valueOf(question.getTempCorrectAnswer()));
//              database.getQuestionDao().insert(question);
//            } else {
//              List<Answer> answers = new LinkedList<>();
//              Answer answer = new Answer();
//              answer.setText(question.getTempCorrectAnswer());
//              answer.setCorrect(true);
//              answers.add(answer);
//              for (String s : question.getTempIncorrectAnswers()) {
//                answer = new Answer();
//                answer.setText(s);
//                answer.setCorrect(false);
//                answers.add(answer);
//              }
//              long id = database.getQuestionDao().insert(question);
//              for (Answer a : answers) {
//                a.setQuestionId(id);
//              }
//              database.getAnswerDao().insert(answers);
//            }
//          }
//        }));
//  }

  public LiveData<List<Question>> getRandQuestionList() {

    return randQuestionList;
  }

  public LiveData<QuestionWithAnswers> getRandomQuestion(){

    return database.getQuestionDao().getRandom();

  }

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
  }

  public int getRandQuestionListSize(){
    return randQuestionList.getValue().size();
  }

  private void getRandomQuestionFromDb() {
    randQuestionList = database.getQuestionDao().getRandomAll();
  }

}
