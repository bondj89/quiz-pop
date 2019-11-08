package dev.jbond.quizpop.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import dev.jbond.quizpop.model.dao.AnswerDao;
import dev.jbond.quizpop.model.dao.GameDao;
import dev.jbond.quizpop.model.dao.QuestionDao;
import dev.jbond.quizpop.model.dao.UserDao;
import dev.jbond.quizpop.model.entity.Answer;
import dev.jbond.quizpop.model.entity.Game;
import dev.jbond.quizpop.model.entity.Question;
import dev.jbond.quizpop.model.entity.User;

@Database(
    entities = {User.class, Answer.class, Game.class, Question.class},
    version = 1, exportSchema = true
)
//@TypeConverters(QuizPopDatabase.Converters.class)
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

//  public static class Converters {

//    @TypeConverter
//    public Enum enumToString(String value) {
//
//      Difficulty diff = null;
//      switch (value) {
//        case "easy":
//          diff = Difficulty.EASY;
//          break;
//        case "medium":
//          diff = Difficulty.MEDIUM;
//          break;
//        case "hard":
//          diff = Difficulty.HARD;
//          break;
//        default:
//          diff = null;
//      }
//      return diff;
//
//    }

//    @TypeConverter
//    public Difficulty stringToDifficulty(String value) {
//      return (value != null) ? Difficulty.valueOf(value.toUpperCase()) : null;
//    }

//
//    @TypeConverter
//    public Type stringToType(String value) {
//      return (value != null) ? Type.valueOf(value.toUpperCase()) : null;
//    }

 // }

}
