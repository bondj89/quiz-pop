package dev.jbond.quizpop.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import dev.jbond.quizpop.model.entity.Question;
import dev.jbond.quizpop.model.entity.User;

@Dao
public interface QuestionDao {
  @Insert
  long insert(Question question);

  @Delete
  int delete(Question...questions);

}
