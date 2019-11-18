package dev.jbond.quizpop.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import dev.jbond.quizpop.model.entity.Game;

/**
 * The interface Game dao.
 */
@Dao
public interface GameDao {

  /**
   * Insert long.
   *
   * @param game the game
   * @return the long
   */
  @Insert
  long insert(Game game);

  /**
   * Gets by id.
   *
   * @param gameId the game id
   * @return the by id
   */
  @Query("SELECT * FROM game WHERE  game_id = :gameId")
  Game getById(long gameId);

  /**
   * Delete int.
   *
   * @param games the games
   * @return the int
   */
  @Delete
  int delete(Game... games);

  /**
   * Update int.
   *
   * @param games the games
   * @return the int
   */
  @Update
  int update(Game... games);

}
