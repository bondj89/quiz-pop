package dev.jbond.quizpop;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import dev.jbond.quizpop.model.entity.Question;
import dev.jbond.quizpop.service.QuizPopDatabase;
import dev.jbond.quizpop.service.QuizPopService;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainViewModel extends AndroidViewModel {

  private static final int DEFAULT_NUMBER_OF_QUESTIONS = 25;

  private LiveData<Question> randomQuestion;
  private ExecutorService executor;
  private QuizPopDatabase database;

  public MainViewModel(@NonNull Application application) {
    super(application);

    database = QuizPopDatabase.getInstance();
    executor = Executors.newSingleThreadExecutor();
    createRandomQuestion();

  }

  public void createRandomQuestion() {
    QuizPopService.getInstance().randomQuestion(DEFAULT_NUMBER_OF_QUESTIONS)
        .subscribeOn(Schedulers.from(executor))
        .subscribe((response -> {
          for (Question question: response.getQuestions()
          ) {
            database.getQuestionDao().insert(question);
          }
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

  public LiveData<Question> getRandomQuestion() {
    return randomQuestion;
  }

  public void getRandomQuestionFromDb() {
    randomQuestion = database.getQuestionDao().getRandom();
  }

}
