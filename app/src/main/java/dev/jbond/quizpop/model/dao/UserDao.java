package dev.jbond.quizpop.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import dev.jbond.quizpop.model.entity.User;

@Dao
public interface UserDao {

  @Insert
  long insert(User user);

  @Delete
  int delete(User...users);
}
