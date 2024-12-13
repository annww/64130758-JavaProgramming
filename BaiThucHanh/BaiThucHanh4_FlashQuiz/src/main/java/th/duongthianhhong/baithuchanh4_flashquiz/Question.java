package th.duongthianhhong.baithuchanh4_flashquiz;

import java.util.List;

public class Question {
  String question, correctAnswer;
  List<String> answers;

  public Question(String question, String correctAnswer, List<String> answers) {
    this.question = question;
    this.correctAnswer = correctAnswer;
    this.answers = answers;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  public List<String> getAnswers() {
    return answers;
  }

  public void setAnswers(List<String> answers) {
    this.answers = answers;
  }
}