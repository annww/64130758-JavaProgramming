package com.example.sum;

import com.almasb.fxgl.entity.action.Action;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.MessageFormat;

public class Controller {
  @FXML
  TextField txtA, txtB;
  @FXML
  Label lblResult;
  public void Sum(ActionEvent e) {
    try {
      float a = Float.parseFloat(txtA.getText());
      float b = Float.parseFloat(txtB.getText());
      float sum = a + b;
      lblResult.setText(String.valueOf(sum));
    }
    catch (NumberFormatException ex) {
      lblResult.setText("Invaild input, please enter vailid number.");
    }
  }
}
