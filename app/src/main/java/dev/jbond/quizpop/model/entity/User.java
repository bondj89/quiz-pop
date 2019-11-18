package dev.jbond.quizpop.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * The type User.
 */
@Entity(
    indices =
    @Index(value = "oauth_key", unique = true)
)
public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long id;

  @ColumnInfo(name = "oauth_key")
  private String oAuthKey;


  @ColumnInfo(index = true, name = "high_score")
  private long highScore;

  /**
   * Gets id.
   *
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets high score.
   *
   * @return the high score
   */
  public long getHighScore() {
    return highScore;
  }

  /**
   * Sets high score.
   *
   * @param highScore the high score
   */
  public void setHighScore(long highScore) {
    this.highScore = highScore;
  }

  /**
   * Gets o auth key.
   *
   * @return the o auth key
   */
  public String getOAuthKey() {
    return oAuthKey;
  }

  /**
   * Sets o auth key.
   *
   * @param oAuthKey the o auth key
   */
  public void setOAuthKey(String oAuthKey) {
    this.oAuthKey = oAuthKey;
  }

}