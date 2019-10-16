package dev.jbond.quizpop.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity (
    foreignKeys = {
        @ForeignKey(
            entity = Question.class,
            parentColumns = {"question_id"},
            childColumns = {"question_id"},
            onDelete = ForeignKey.CASCADE
        )

    },
    indices = @Index(value = "correct_id", unique = true)
)
public class Answer {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "answer_id")
  private long id;

  @ColumnInfo
  private String text;

  public long getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
