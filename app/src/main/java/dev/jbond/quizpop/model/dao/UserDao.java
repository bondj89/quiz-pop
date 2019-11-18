package dev.jbond.quizpop.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import dev.jbond.quizpop.model.entity.User;

/**
 * The interface User dao.
 */
@Dao
public interface UserDao {

  /**
   * Insert long.
   *
   * @param user the user
   * @return the long
   */
  @Insert
  long insert(User user);

  /**
   * Gets by o auth.
   *
   * @param oAuthKey the o auth key
   * @return the by o auth
   */
  @Query("SELECT * FROM User WHERE  oauth_key = :oAuthKey")
  User getByOAuth(String oAuthKey);

  /**
   * Delete int.
   *
   * @param users the users
   * @return the int
   */
  @Delete
  int delete(User... users);
}
