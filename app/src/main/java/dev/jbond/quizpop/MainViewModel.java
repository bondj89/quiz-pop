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
    QuizPopService.getInstance().randomQuestion()
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
