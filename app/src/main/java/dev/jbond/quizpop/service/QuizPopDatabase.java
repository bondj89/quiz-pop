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

/**
 * The type Quiz pop database.
 */
@Database(
    entities = {User.class, Answer.class, Game.class, Question.class},
    version = 1, exportSchema = true
)
@TypeConverters(QuizPopDatabase.Converters.class)
public abstract class QuizPopDatabase extends RoomDatabase {

  /**
   * Instantiates a new Quiz pop database.
   */
  QuizPopDatabase() {
  }

  private static Application applicationContext;

  /**
   * Sets application context.
   *
   * @param applicationContext the application context
   */
  public static void setApplicationContext(Application applicationContext) {
    QuizPopDatabase.applicationContext = applicationContext;
  }

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static QuizPopDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Gets user dao.
   *
   * @return the user dao
   */
  public abstract UserDao getUserDao();

  /**
   * Gets answer dao.
   *
   * @return the answer dao
   */
  public abstract AnswerDao getAnswerDao();

  /**
   * Gets game dao.
   *
   * @return the game dao
   */
  public abstract GameDao getGameDao();

  /**
   * Gets question dao.
   *
   * @return the question dao
   */
  public abstract QuestionDao getQuestionDao();

  private static class InstanceHolder {

    private static final QuizPopDatabase INSTANCE;

    static {
      INSTANCE =
          Room.databaseBuilder(applicationContext, QuizPopDatabase.class, "quiz_pop_db").build();
    }
  }

  /**
   * The type Converters.
   */
  public static class Converters {

    /**
     * Enum to string string.
     *
     * @param value the value
     * @return the string
     */
    @TypeConverter
    public String enumToString(Enum value) {
      return (value != null) ? value.toString() : null;
    }

    /**
     * String to difficulty difficulty.
     *
     * @param value the value
     * @return the difficulty
     */
    @TypeConverter
    public Difficulty stringToDifficulty(String value) {
      return (value != null) ? Difficulty.valueOf(value.toUpperCase()) : null;
    }


    /**
     * String to type type.
     *
     * @param value the value
     * @return the type
     */
    @TypeConverter
    public Type stringToType(String value) {
      return (value != null) ? Type.valueOf(value.toUpperCase()) : null;
    }

  }

}
