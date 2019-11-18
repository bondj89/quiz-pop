package dev.jbond.quizpop.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The type Question.
 */
@Entity(indices = @Index(value = "question", unique = true))
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
  @SerializedName("difficulty")
  private Difficulty difficulty;

  @Expose
  @SerializedName("question")
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
  @SerializedName("incorrect_answers")
  private String[] tempIncorrectAnswers;

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
   * Gets category.
   *
   * @return the category
   */
  public String getCategory() {
    return category;
  }

  /**
   * Sets category.
   *
   * @param category the category
   */
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * Gets type.
   *
   * @return the type
   */
  public Type getType() {
    return type;
  }

  /**
   * Sets type.
   *
   * @param type the type
   */
  public void setType(Type type) {
    this.type = type;
  }

  /**
   * Gets difficulty.
   *
   * @return the difficulty
   */
  @NonNull
  public Difficulty getDifficulty() {
    return difficulty;
  }

  /**
   * Sets difficulty.
   *
   * @param difficulty the difficulty
   */
  public void setDifficulty(Difficulty difficulty) {
    this.difficulty = difficulty;
  }

  /**
   * Gets text.
   *
   * @return the text
   */
  @NonNull
  public String getText() {
    return text;
  }

  /**
   * Sets text.
   *
   * @param text the text
   */
  public void setText(@NonNull String text) {
    this.text = text;
  }


  /**
   * Gets correct.
   *
   * @return the correct
   */
  public Boolean getCorrect() {
    return correct;
  }

  /**
   * Sets correct.
   *
   * @param correct the correct
   */
  public void setCorrect(Boolean correct) {
    this.correct = correct;
  }

  /**
   * Gets temp correct answer.
   *
   * @return the temp correct answer
   */
  public String getTempCorrectAnswer() {
    return tempCorrectAnswer;
  }

  /**
   * Sets temp correct answer.
   *
   * @param tempCorrectAnswer the temp correct answer
   */
  public void setTempCorrectAnswer(String tempCorrectAnswer) {
    this.tempCorrectAnswer = tempCorrectAnswer;
  }

  /**
   * Get temp incorrect answers string [ ].
   *
   * @return the string [ ]
   */
  public String[] getTempIncorrectAnswers() {
    return tempIncorrectAnswers;
  }

  /**
   * Sets temp incorrect answers.
   *
   * @param tempIncorrectAnswers the temp incorrect answers
   */
  public void setTempIncorrectAnswers(String[] tempIncorrectAnswers) {
    this.tempIncorrectAnswers = tempIncorrectAnswers;
  }

  /**
   * The enum Difficulty.
   */
  public enum Difficulty {
    /**
     * Easy difficulty.
     */
    @SerializedName("easy")
    EASY,
    /**
     * Medium difficulty.
     */
    @SerializedName("medium")
    MEDIUM,
    /**
     * Hard difficulty.
     */
    @SerializedName("hard")
    HARD
  }

  /**
   * The enum Type.
   */
  public enum Type {
    /**
     * Multiple type.
     */
    @SerializedName("multiple")
    MULTIPLE,
    /**
     * Boolean type.
     */
    @SerializedName("boolean")
    BOOLEAN
  }

}
