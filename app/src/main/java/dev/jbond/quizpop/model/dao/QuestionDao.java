package dev.jbond.quizpop.model.dao;

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
  Question getById(long questionId);

  @Delete
  int delete(Question... questions);

}
