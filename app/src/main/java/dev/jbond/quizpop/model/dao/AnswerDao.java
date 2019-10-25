package dev.jbond.quizpop.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import dev.jbond.quizpop.model.entity.Answer;
import dev.jbond.quizpop.model.entity.Game;

@Dao
public interface AnswerDao {
  @Insert
  long insert(Answer answer);

  @Query("SELECT * FROM game WHERE  game_id = :gameId")
  Game getById(long gameId);

  @Delete
  int delete(Answer...answers);
}
