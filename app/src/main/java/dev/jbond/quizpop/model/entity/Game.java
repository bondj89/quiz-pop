package dev.jbond.quizpop.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import dev.jbond.quizpop.model.entity.Question.Difficulty;


/**
 * The type Game.
 */
@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            childColumns = "user_id",
            parentColumns = "user_id",
            onDelete = ForeignKey.CASCADE
        )
    },
    indices = {
        @Index(value = {"total", "score"})
    }
)
public class Game {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "game_id")
  private long id;

  private Difficulty difficulty;

  @ColumnInfo(name = "user_id", index = true)
  private Long userId;

  private int score;

  private int total;

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
   * Gets user id.
   *
   * @return the user id
   */
  public Long getUserId() {
    return userId;
  }

  /**
   * Sets user id.
   *
   * @param userId the user id
   */
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  /**
   * Gets score.
   *
   * @return the score
   */
  public int getScore() {
    return score;
  }

  /**
   * Sets score.
   *
   * @param score the score
   */
  public void setScore(int score) {
    this.score = score;
  }

  /**
   * Gets difficulty.
   *
   * @return the difficulty
   */
  public Difficulty getDifficulty() {
    return difficulty;
  }

  /**
   * Sets difficulty.
   *
   * @param difficulty the difficulty
   */
  public void setDifficulty(Difficulty difficulty) {
    this.difficulty = difficulty;
  }

  /**
   * Gets total.
   *
   * @return the total
   */
  public int getTotal() {
    return total;
  }

  /**
   * Sets total.
   *
   * @param total the total
   */
  public void setTotal(int total) {
    this.total = total;
  }
}
