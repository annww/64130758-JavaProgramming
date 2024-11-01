package thigk.de2.de2_cau3_64130758;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class mathController {
  @FXML
  private TextField soA;
  @FXML
  private TextField soB;
  @FXML
  private TextField phepToan;
  @FXML
  private Label timerLabel;
  @FXML
  private Label pointLabel;
  @FXML
  private Button option1Button;
  @FXML
  private Button option2Button;
  @FXML
  private Button option3Button;
  @FXML
  private Button option4Button;

  private int correctAnswer;
  private int score = 0;
  private int timeLeft = 5;
  private Timeline timeline;
  private boolean isAnswered = false;

  public mathController() {
  }

  @FXML
  public void initialize() {
    this.pointLabel.setText("Điểm: 0");
    this.generateQuiz();
  }

  private void startTimer() {
    this.timeLeft = 5;
    this.timerLabel.setText(String.valueOf(this.timeLeft));
    if (this.timeline != null) {
      this.timeline.stop();
    }

    this.timeline = new Timeline(new KeyFrame[]{new KeyFrame(Duration.seconds(1.0), (event) -> {
      --this.timeLeft;
      this.timerLabel.setText(String.valueOf(this.timeLeft));
      if (this.timeLeft <= 0) {
        this.stopTimer();
        this.generateQuiz();
      }

    }, new KeyValue[0])});
    this.timeline.setCycleCount(-1);
    this.timeline.play();
  }

  private void stopTimer() {
    if (this.timeline != null) {
      this.timeline.stop();
      this.timeline = null;
    }
  }

  private void generateQuiz() {
    Random rand = new Random();
    int a = rand.nextInt(100) + 1;
    int b = rand.nextInt(100) + 1;
    this.soA.setText(String.valueOf(a));
    this.soB.setText(String.valueOf(b));
    String[] operations = new String[]{"+", "-", "*", "/", "div", "mod"};
    String operation = operations[rand.nextInt(operations.length)];
    this.phepToan.setText(operation);
    switch (operation) {
      case "+" -> this.correctAnswer = a + b;
      case "-" -> this.correctAnswer = a - b;
      case "*" -> this.correctAnswer = a * b;
      case "/" -> this.correctAnswer = b != 0 ? a / b : 0;
      case "div" -> this.correctAnswer = b != 0 ? a / b : 0;
      case "mod" -> this.correctAnswer = b != 0 ? a % b : 0;
    }

    ArrayList<Integer> options = new ArrayList();
    options.add(this.correctAnswer);

    while(options.size() < 4) {
      int wrongAnswer = this.correctAnswer + rand.nextInt(10) - 5;
      if (!options.contains(wrongAnswer)) {
        options.add(wrongAnswer);
      }
    }

    Collections.shuffle(options);
    this.option1Button.setText(String.valueOf(options.get(0)));
    this.option2Button.setText(String.valueOf(options.get(1)));
    this.option3Button.setText(String.valueOf(options.get(2)));
    this.option4Button.setText(String.valueOf(options.get(3)));
    this.resetButtonStyles();
    this.isAnswered = false;
    this.startTimer();
  }

  @FXML
  private void handleAnswer(ActionEvent event) {
    if (!this.isAnswered) {
      Button selectedButton = (Button)event.getSource();
      int selectedAnswer = Integer.parseInt(selectedButton.getText());
      if (selectedAnswer == this.correctAnswer) {
        selectedButton.setStyle("-fx-background-color: green;");
        ++this.score;
        this.pointLabel.setText("Điểm: " + this.score);
      } else {
        selectedButton.setStyle("-fx-background-color: red;");
      }

      this.isAnswered = true;
      this.stopTimer();
      Timeline delayTimeline = new Timeline(new KeyFrame[]{new KeyFrame(Duration.seconds(1.0), (e) -> {
        this.generateQuiz();
      }, new KeyValue[0])});
      delayTimeline.setCycleCount(1);
      delayTimeline.play();
    }
  }



  private void resetButtonStyles() {
    this.option1Button.setStyle("-fx-background-color: #add8e6;");
    this.option2Button.setStyle("-fx-background-color: #add8e6;");
    this.option3Button.setStyle("-fx-background-color: #add8e6;");
    this.option4Button.setStyle("-fx-background-color: #add8e6;");
  }

  @FXML
  private void buttonclick() {
    this.stopTimer();
    this.generateQuiz();
  }
}
