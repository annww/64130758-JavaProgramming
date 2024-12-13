package th.duongthianhhong.th_bai5_simpledict;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TuDien {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}