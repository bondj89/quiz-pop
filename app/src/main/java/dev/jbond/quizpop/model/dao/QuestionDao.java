package dev.jbond.quizpop.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import dev.jbond.quizpop.model.entity.Question;

@Dao
public interface QuestionDao {
  @Insert
  long insert(Question question);

}
