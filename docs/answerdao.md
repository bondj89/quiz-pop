## AnswerDao Source Code

```
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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean isCorrect() {
    return correct;
  }

  public void setCorrect(boolean correct) {
    this.correct = correct;
  }

  public long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(long questionId) {
    this.questionId = questionId;
  }
}

``` 