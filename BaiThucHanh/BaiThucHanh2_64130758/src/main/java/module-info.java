module daihocnhatrang.duongthianhhong.baithuchanh2_64130758 {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.bootstrapfx.core;

  opens th.duongthianhhong.BasicGUI_BMI to javafx.fxml;
  exports th.duongthianhhong.BasicGUI_BMI;
}