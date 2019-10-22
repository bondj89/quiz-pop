package dev.jbond.quizpop.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import dev.jbond.quizpop.model.entity.Game;
import dev.jbond.quizpop.model.entity.User;

@Dao
public interface GameDao {

  @Insert
  long insert(Game game);

  @Delete
  int delete(Game...games);
}
