package th.duongthianhhong.baithuchanh1_641308758;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class HelloController {

  @FXML
  private TextField txta, txtb, result;
  @FXML
  private RadioButton rbcong, rbtru, rbnhan, rbchia;

  @FXML
  private void handleTinh(ActionEvent event) {
    if (!(rbcong.isSelected() || rbtru.isSelected() || rbnhan.isSelected() || rbchia.isSelected())) {
      result.setText("Chọn phép toán!");
      return;
    }

    double a = Double.parseDouble(txta.getText());
    double b = Double.parseDouble(txtb.getText());
    double res = 0;

    if (rbcong.isSelected()) {
      res = a + b;
    } else if (rbtru.isSelected()) {
      res = a - b;
    } else if (rbnhan.isSelected()) {
      res = a * b;
    } else if (rbchia.isSelected()) {
      if (b != 0) {
        res = a / b;
      } else {
        result.setText("Lỗi: Chia cho 0");
        return;
      }
    }

    result.setText(String.valueOf(res));

    rbcong.setSelected(false);
    rbtru.setSelected(false);
    rbnhan.setSelected(false);
    rbchia.setSelected(false);
  }
}