package dev.jbond.quizpop.model.pojo;

import androidx.room.Relation;
import dev.jbond.quizpop.model.entity.Answer;
import dev.jbond.quizpop.model.entity.Question;
import java.util.List;

public class QuestionWithAnswers extends Question {

  @Relation(entity = Answer.class, entityColumn = "question_id", parentColumn = "question_id")
  private List<Answer> answers;

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }
}
