package dev.jbond.quizpop.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import dev.jbond.quizpop.model.entity.Question;
import java.util.Collection;
import java.util.List;

@Dao
public interface QuestionDao {

  @Insert
  long insert(Question question);

  @Insert
  List<Long> insert(Collection<Question> questions);

  @Query("SELECT * FROM Question WHERE  question_id = :questionId")
  LiveData<Question> getById(long questionId);

  @Query("SELECT * FROM Question")
  LiveData<Question> getRandom();

  @Delete
  int delete(Question... questions);

}
