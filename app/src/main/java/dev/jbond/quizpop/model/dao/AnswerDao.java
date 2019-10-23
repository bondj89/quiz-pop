package dev.jbond.quizpop.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import dev.jbond.quizpop.model.entity.Answer;

@Dao
public interface AnswerDao {
  @Insert
  long insert(Answer answer);

  @Delete
  int delete(Answer...answers);
}
