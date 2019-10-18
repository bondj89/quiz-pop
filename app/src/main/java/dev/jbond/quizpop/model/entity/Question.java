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

  private String type;

  private String difficulty;

  @NonNull
  private String questionText;

  private String correctAnswers;

  private List<String> incorrectAnswers;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }

  @NonNull
  public String getQuestionText() {
    return questionText;
  }

  public void setQuestionText(@NonNull String questionText) {
    this.questionText = questionText;
  }

  public String getCorrectAnswers() {
    return correctAnswers;
  }

  public void setCorrectAnswers(String correctAnswers) {
    this.correctAnswers = correctAnswers;
  }

  public List<String> getIncorrectAnswers() {
    return incorrectAnswers;
  }

  public void setIncorrectAnswers(List<String> incorrectAnswers) {
    this.incorrectAnswers = incorrectAnswers;
  }
}
