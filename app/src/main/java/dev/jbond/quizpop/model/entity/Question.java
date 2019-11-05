package dev.jbond.quizpop.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Question {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "question_id")
  private long id;

  @Expose
  private String category;

  @Expose
  private Type type;

  @Expose
  @NonNull
  @ColumnInfo(name = "difficulty")
  private Difficulty difficulty;

  @Expose
  @ColumnInfo(name = "question")
  @NonNull
  private String text;

  private Boolean correct;

  @Expose
  @Ignore
  @SerializedName("correct_answer")
  private String tempCorrectAnswer;

  @Expose
  @Ignore
  @SerializedName("incorrect_answer")
  private String[] tempIncorrectAnswers;

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

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  @NonNull
  public Difficulty getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(Difficulty difficulty) {
    this.difficulty = difficulty;
  }

  @NonNull
  public String getText() {
    return text;
  }

  public void setText(@NonNull String text) {
    this.text = text;
  }

  public Boolean getCorrect() {
    return correct;
  }

  public void setCorrect(Boolean correct) {
    this.correct = correct;
  }

  public String getTempCorrectAnswer() {
    return tempCorrectAnswer;
  }

  public void setTempCorrectAnswer(String tempCorrectAnswer) {
    this.tempCorrectAnswer = tempCorrectAnswer;
  }

  public String[] getTempIncorrectAnswers() {
    return tempIncorrectAnswers;
  }

  public void setTempIncorrectAnswers(String[] tempIncorrectAnswers) {
    this.tempIncorrectAnswers = tempIncorrectAnswers;
  }

  public enum Difficulty {
    EASY,
    MEDIUM,
    HARD
  }

  public enum Type {
    MULTIPLE,
    BOOLEAN
  }

}
