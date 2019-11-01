package dev.jbond.quizpop.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import dev.jbond.quizpop.model.entity.Question;

@Dao
public interface QuestionDao {

  @Insert
  long insert(Question question);

  @Query("SELECT * FROM Question WHERE  question_id = :questionId")
  LiveData<Question> getById(long questionId);

  @Query("SELECT * FROM Question")
  LiveData<Question> getRandom();

  @Delete
  int delete(Question... questions);

}
