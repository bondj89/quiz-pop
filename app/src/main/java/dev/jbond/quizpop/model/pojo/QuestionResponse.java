package dev.jbond.quizpop.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import dev.jbond.quizpop.model.entity.Question;
import java.util.List;
public class QuestionResponse {

  @Expose
  @SerializedName("response_code")
  private int code;

  @Expose
  @SerializedName("results")
  private List<Question> questions;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public List<Question> getQuestions() {
    return questions;
  }

  public void setQuestions(List<Question> questions) {
    this.questions = questions;
  }
}
