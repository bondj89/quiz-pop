package dev.jbond.quizpop.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import dev.jbond.quizpop.model.entity.Answer;
import dev.jbond.quizpop.model.entity.Game;
import java.util.Collection;
import java.util.List;

/**
 * The interface Answer dao.
 */
@Dao
public interface AnswerDao {

  /**
   * Insert long.
   *
   * @param answer the answer
   * @return the long
   */
  @Insert
  long insert(Answer answer);

  /**
   * Insert list.
   *
   * @param answers the answers
   * @return the list
   */
  @Insert
  List<Long> insert(Collection<Answer> answers);

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
   * @param answers the answers
   * @return the int
   */
  @Delete
  int delete(Answer...answers);
}
