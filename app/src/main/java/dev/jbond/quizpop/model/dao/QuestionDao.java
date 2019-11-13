package dev.jbond.quizpop.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import dev.jbond.quizpop.model.entity.Question;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface QuestionDao {

  @Insert
  long insert(Question question);

  @Insert
  List<Long> insert(Collection<Question> questions);

  @Query("SELECT COUNT(*) FROM QUESTION")
  Single<Integer> count();

  @Query("SELECT * FROM Question WHERE  question_id = :questionId")
  LiveData<Question> getById(long questionId);

  @Query("SELECT * FROM Question ORDER BY RANDOM()")
  LiveData<List<Question>> getRandomAll();

  @Query("SELECT * FROM Question ORDER BY RANDOM() LIMIT 1")
  LiveData<Question> getRandom();

  @Delete
  int delete(Question... questions);

}
