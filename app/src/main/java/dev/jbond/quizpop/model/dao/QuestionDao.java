package dev.jbond.quizpop.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import dev.jbond.quizpop.model.entity.Question;
import dev.jbond.quizpop.model.pojo.QuestionWithAnswers;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface QuestionDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  long insert(Question question);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Long> insert(Collection<Question> questions);

  @Query("SELECT COUNT(*) FROM QUESTION")
  Single<Integer> count();

  @Query("SELECT * FROM Question WHERE  question_id = :questionId")
  LiveData<Question> getById(long questionId);

  @Query("SELECT * FROM Question ORDER BY RANDOM()")
  LiveData<List<Question>> getRandomAll();

  @Transaction
  @Query("SELECT * FROM Question ORDER BY RANDOM() LIMIT 1")
  LiveData<QuestionWithAnswers> getRandom();

  @Delete
  int delete(Question... questions);

}
