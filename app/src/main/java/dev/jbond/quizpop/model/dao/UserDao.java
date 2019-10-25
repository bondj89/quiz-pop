package dev.jbond.quizpop.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import dev.jbond.quizpop.model.entity.User;

@Dao
public interface UserDao {

  @Insert
  long insert(User user);

  @Query("SELECT * FROM User WHERE  oauth_key = :oAuthKey")
  User getByOAuth(String oAuthKey);

  @Delete
  int delete(User... users);
}
