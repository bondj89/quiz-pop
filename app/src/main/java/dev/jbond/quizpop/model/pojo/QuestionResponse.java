package dev.jbond.quizpop.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import dev.jbond.quizpop.model.entity.Question;
import java.util.List;


/**
 * The type Question response.
 */
public class QuestionResponse {

  @Expose
  @SerializedName("response_code")
  private int code;

  @Expose
  @SerializedName("results")
  private List<Question> questions;

  /**
   * Gets code.
   *
   * @return the code
   */
  public int getCode() {
    return code;
  }

  /**
   * Sets code.
   *
   * @param code the code
   */
  public void setCode(int code) {
    this.code = code;
  }

  /**
   * Gets questions.
   *
   * @return the questions
   */
  public List<Question> getQuestions() {
    return questions;
  }

  /**
   * Sets questions.
   *
   * @param questions the questions
   */
  public void setQuestions(List<Question> questions) {
    this.questions = questions;
  }
}
