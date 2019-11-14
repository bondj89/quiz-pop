package dev.jbond.quizpop.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            childColumns = "user_id",
            parentColumns = "user_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Game {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "game_id")
  private long id;

  private String difficulty;

  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  @ColumnInfo(index = true, name = "score")
  private int score;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }

  public String getDifficulty() {
    return difficulty;
  }

}
