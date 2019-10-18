package dev.jbond.quizpop.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import java.util.List;

public class Question {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "question_id")
  private long id;

  private String category;

  private enum Type {
    MULTIPLE, TRUE_FALSE
  }

  private enum Difficulty {
    easy, medium, hard
  }

  @NonNull
  private String questionText;

  private String correctAnswers;

  private List<String> incorrectAnswers;








}
