package dev.jbond.quizpop.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import dev.jbond.quizpop.model.entity.Answer;
import dev.jbond.quizpop.model.entity.Game;
import java.util.Collection;
import java.util.List;

@Dao
public interface AnswerDao {
  @Insert
  long insert(Answer answer);

  @Insert
  List<Long> insert(Collection<Answer> answers);

  @Query("SELECT * FROM game WHERE  game_id = :gameId")
  Game getById(long gameId);

  @Delete
  int delete(Answer...answers);
}
