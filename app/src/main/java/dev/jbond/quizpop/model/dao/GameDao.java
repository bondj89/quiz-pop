package dev.jbond.quizpop.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import dev.jbond.quizpop.model.entity.Game;

@Dao
public interface GameDao {

  @Insert
  long insert(Game game);
}
