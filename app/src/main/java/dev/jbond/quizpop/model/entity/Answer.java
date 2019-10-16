package dev.jbond.quizpop.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Answer {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "answer_id")
  private long id;
}
