package dev.jbond.quizpop.model.pojo;

import androidx.room.Relation;
import dev.jbond.quizpop.model.entity.Answer;
import dev.jbond.quizpop.model.entity.Question;
import java.util.List;

/**
 * The type Question with answers.
 */
public class QuestionWithAnswers extends Question {

  @Relation(entity = Answer.class, entityColumn = "question_id", parentColumn = "question_id")
  private List<Answer> answers;

  /**
   * Gets answers.
   *
   * @return the answers
   */
  public List<Answer> getAnswers() {
    return answers;
  }

  /**
   * Sets answers.
   *
   * @param answers the answers
   */
  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }
}
