package dev.jbond.quizpop.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Question.class,
            childColumns = "question_id",
            parentColumns = "question_id",
            onDelete = ForeignKey.CASCADE
        ),
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


  @ColumnInfo(name = "question_id")
  private Long questionId;

  @ColumnInfo(name = "user_id")
  private Long userId;

  @ColumnInfo(index = true,name = "score")
  private long score;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public long getScore() {
    return score;
  }

  public void setScore(long score) {
    this.score = score;
  }
}
