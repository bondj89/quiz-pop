package dev.jbond.quizpop.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long id;

  private long highScore;

  public long getId() {
    return id;
  }

  public long getHighScore() {
    return highScore;
  }

  public void setHighScore(long highScore) {
    this.highScore = highScore;
  }
}
