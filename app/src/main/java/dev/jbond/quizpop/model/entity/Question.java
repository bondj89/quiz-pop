package dev.jbond.quizpop.model.entity;


import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Question  {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "question_id")
  private long id;

  @NonNull
  @ColumnInfo(name = "text", index = true)
  private String text;

  private boolean correct;

}
