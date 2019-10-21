package dev.jbond.quizpop.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import dev.jbond.quizpop.model.dao.UserDao;
import dev.jbond.quizpop.model.entity.User;

@Database(
    entities = {User.class},
    version = 1, exportSchema = true
)
// @TypeConverters(QuizPopDatabase.Converter.class)
public abstract class QuizPopDatabase extends RoomDatabase {

  protected QuizPopDatabase() {}

  private static Application applicationContext;

  public static void setApplicationContext(Application applicationContext) {
    QuizPopDatabase.applicationContext = applicationContext;
  }

  public static QuizPopDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract UserDao getUserDao();

  // public abstract CardDao getCardDao();

  // public abstract RoundDao getRoundDao();

  // public abstract HandDao getHandDao();

  private static class InstanceHolder {

    private static final QuizPopDatabase INSTANCE;

    static {
      INSTANCE =
          Room.databaseBuilder(applicationContext, QuizPopDatabase.class, "quiz_pop_db").build();
    }

  }
}
