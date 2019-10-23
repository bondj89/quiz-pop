package dev.jbond.quizpop.model.entity;

import android.support.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

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


  @ColumnInfo(index = true,name = "high_score")
  private long highScore;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }



  public long getHighScore() {
    return highScore;
  }

  public void setHighScore(long highScore) {
    this.highScore = highScore;
  }
}