package dev.jbond.quizpop;

import android.app.Application;
import android.content.Context;
import com.facebook.stetho.Stetho;
import dev.jbond.quizpop.service.GoogleSignInService;
import dev.jbond.quizpop.service.QuizPopDatabase;

public class QuizPopApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    QuizPopDatabase.setApplicationContext(this);
    GoogleSignInService.setApplicationContext(this);
    final QuizPopDatabase database = QuizPopDatabase.getInstance();
    new Thread(new Runnable() {
      @Override
      public void run() {
        database.getUserDao().delete();
        database.getAnswerDao().delete();
        database.getGameDao().delete();
        database.getQuestionDao().delete();
      }
    }).start();
  }


}
