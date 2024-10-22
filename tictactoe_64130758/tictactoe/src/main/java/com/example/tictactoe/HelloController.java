package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    @FXML
    private Label winertext;
    private int playerTurn = 0;
    private boolean gameOver = false; // Cờ để theo dõi trạng thái trò chơi
    ArrayList<Button> buttons;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));
        buttons.forEach(button -> {
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    @FXML
    public void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        winertext.setText("");
        gameOver = false; // Đặt lại cờ khi khởi động lại trò chơi
    }

    private void resetButton(Button button) {
        button.setDisable(false);
        button.setText("");
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            if (!gameOver) { // Kiểm tra nếu trò chơi chưa kết thúc
                setPlayerSymbol(button);
                button.setDisable(true);
                checkIfGameIsOver();
            }
        });
    }

    private void setPlayerSymbol(Button button) {
        if (playerTurn % 2 == 0) {
            button.setText("X");
            playerTurn = 1;
        } else {
            button.setText("O");
            playerTurn = 0;
        }
    }

    private void checkIfGameIsOver() {
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> button1.getText() + button2.getText() + button3.getText();
                case 1 -> button4.getText() + button5.getText() + button6.getText();
                case 2 -> button7.getText() + button8.getText() + button9.getText();
                case 3 -> button1.getText() + button4.getText() + button7.getText();
                case 4 -> button2.getText() + button5.getText() + button8.getText();
                case 5 -> button3.getText() + button6.getText() + button9.getText();
                case 6 -> button1.getText() + button5.getText() + button9.getText();
                case 7 -> button3.getText() + button5.getText() + button7.getText();
                default -> null;
            };

            if (line.equals("XXX")) {
                winertext.setText("X won!");
                endGame();
                return;
            } else if (line.equals("OOO")) {
                winertext.setText("O won!");
                endGame();
                return;
            }
        }

        if (buttons.stream().allMatch(button -> !button.getText().isEmpty())) {
            winertext.setText("It's a tie!"); // Thông báo hòa
            endGame();
        }
    }

    private void endGame() {
        gameOver = true; // Đặt cờ trò chơi đã kết thúc
        buttons.forEach(button -> button.setDisable(true)); // Vô hiệu hóa tất cả các nút
    }
}
