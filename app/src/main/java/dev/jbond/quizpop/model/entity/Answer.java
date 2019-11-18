package dev.jbond.quizpop.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/**
 * The type Answer.
 */
@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Question.class,
            childColumns = "question_id",
            parentColumns = "question_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Answer {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "answer_id")
  private long id;

  @ColumnInfo(name = "question_id", index = true)
  private long questionId;

  private String text;

  private boolean correct;

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
   * Gets text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Sets text.
   *
   * @param text the text
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Is correct boolean.
   *
   * @return the boolean
   */
  public boolean isCorrect() {
    return correct;
  }

  /**
   * Sets correct.
   *
   * @param correct the correct
   */
  public void setCorrect(boolean correct) {
    this.correct = correct;
  }

  /**
   * Gets question id.
   *
   * @return the question id
   */
  public long getQuestionId() {
    return questionId;
  }

  /**
   * Sets question id.
   *
   * @param questionId the question id
   */
  public void setQuestionId(long questionId) {
    this.questionId = questionId;
  }
}
