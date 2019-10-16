package dev.jbond.quizpop.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity (
    foreignKeys = {
        @ForeignKey(
            entity = Question.class,
            parentColumns = {"question_id"},
            childColumns = {"question_id"},
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Answer {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "answer_id")
  private long id;
}
