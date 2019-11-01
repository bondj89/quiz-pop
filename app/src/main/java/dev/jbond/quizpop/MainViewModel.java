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
        .subscribe((question -> {
          database.getQuestionDao().insert(question);
        }));
  }

  public LiveData<Question> getRandomQuestion() {
    return randomQuestion;
  }

  public void getRandomQuestionFromDb() {
    randomQuestion = database.getQuestionDao().getRandom();
  }

}
