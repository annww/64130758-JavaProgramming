package th.duongthianhhong.BasicGUI_BMI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BMIController implements Initializable {

  @FXML
  private TextField txtHeight;
  @FXML
  private TextField txtWeight;
  @FXML
  private CheckBox cbNguoiChauA;
  @FXML
  private TextField result;

  @FXML
  public void handleTinh() {
    try {
      double height = Double.parseDouble(txtHeight.getText());
      double weight = Double.parseDouble(txtWeight.getText());

      height = height / 100;
      double bmi = weight / (height * height);
      String category = "";
      boolean isAsian = cbNguoiChauA.isSelected();

      if (isAsian) {
        if (bmi < 17.5) {
          category = "Thiếu cân";
        } else if (bmi >= 17.5 && bmi <= 22.99) {
          category = "Bình thường";
        } else if (bmi >= 23 && bmi <= 27.99) {
          category = "Thừa cân";
        } else {
          category = "Béo phì";
        }
      } else {
        if (bmi < 18.5) {
          category = "Thiếu cân";
        } else if (bmi >= 18.5 && bmi <= 24.99) {
          category = "Bình thường";
        } else if (bmi >= 25 && bmi <= 29.99) {
          category = "Thừa cân";
        } else {
          category = "Béo phì";
        }
      }

      result.setText("BMI: " + String.format("%.2f", bmi) + " - " + category);
    } catch (NumberFormatException e) {
      result.setText("Vui lòng nhập dữ liệu hợp lệ!");
    }
  }
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    result.setEditable(false);
  }
}
