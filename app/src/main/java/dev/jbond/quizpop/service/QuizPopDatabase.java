package dev.jbond.quizpop.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import dev.jbond.quizpop.model.dao.AnswerDao;
import dev.jbond.quizpop.model.dao.GameDao;
import dev.jbond.quizpop.model.dao.QuestionDao;
import dev.jbond.quizpop.model.dao.UserDao;
import dev.jbond.quizpop.model.entity.Answer;
import dev.jbond.quizpop.model.entity.Game;
import dev.jbond.quizpop.model.entity.Question;
import dev.jbond.quizpop.model.entity.Question.Difficulty;
import dev.jbond.quizpop.model.entity.Question.Type;
import dev.jbond.quizpop.model.entity.User;

@Database(
    entities = {User.class, Answer.class, Game.class, Question.class},
    version = 1, exportSchema = true
)
@TypeConverters(QuizPopDatabase.Converters.class)
public abstract class QuizPopDatabase extends RoomDatabase {

  QuizPopDatabase() {
  }

  private static Application applicationContext;

  public static void setApplicationContext(Application applicationContext) {
    QuizPopDatabase.applicationContext = applicationContext;
  }

  public static QuizPopDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract UserDao getUserDao();

  public abstract AnswerDao getAnswerDao();

  public abstract GameDao getGameDao();

  public abstract QuestionDao getQuestionDao();

  private static class InstanceHolder {

    private static final QuizPopDatabase INSTANCE;

    static {
      INSTANCE =
          Room.databaseBuilder(applicationContext, QuizPopDatabase.class, "quiz_pop_db").build();
    }
  }

  public static class Converters {

    @TypeConverter
    public String enumToString(Enum value) {
      return (value != null) ? value.toString() : null;
    }

    @TypeConverter
    public Difficulty stringToDifficulty(String value) {
      return (value != null) ? Difficulty.valueOf(value.toUpperCase()) : null;
    }

    @TypeConverter
    public Type stringToType(String value) {
      return (value != null) ? Type.valueOf(value.toUpperCase()) : null;
    }

  }

}
