package th.duongthianhhong.baithuchanh3_flashquizgui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FlashQuizGUI {
  @FXML
  private Label welcomeText;

  @FXML
  protected void onHelloButtonClick() {
    welcomeText.setText("Welcome to JavaFX Application!");
  }
}