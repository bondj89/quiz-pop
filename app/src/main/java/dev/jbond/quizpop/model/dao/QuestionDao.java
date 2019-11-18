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

/**
 * The interface Question dao.
 */
@Dao
public interface QuestionDao {

  /**
   * Insert long.
   *
   * @param question the question
   * @return the long
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  long insert(Question question);

  /**
   * Insert list.
   *
   * @param questions the questions
   * @return the list
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Long> insert(Collection<Question> questions);

  /**
   * Count single.
   *
   * @return the single
   */
  @Query("SELECT COUNT(*) FROM QUESTION")
  Single<Integer> count();

  /**
   * Gets by id.
   *
   * @param questionId the question id
   * @return the by id
   */
  @Query("SELECT * FROM Question WHERE  question_id = :questionId")
  LiveData<Question> getById(long questionId);

  /**
   * Gets random all.
   *
   * @return the random all
   */
  @Query("SELECT * FROM Question ORDER BY RANDOM()")
  LiveData<List<Question>> getRandomAll();

  /**
   * Gets random.
   *
   * @return the random
   */
  @Transaction
  @Query("SELECT * FROM Question ORDER BY RANDOM() LIMIT 1")
  LiveData<QuestionWithAnswers> getRandom();

  /**
   * Delete int.
   *
   * @param questions the questions
   * @return the int
   */
  @Delete
  int delete(Question... questions);

}
