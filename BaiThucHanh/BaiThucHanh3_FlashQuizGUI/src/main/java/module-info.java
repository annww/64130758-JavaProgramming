module th.duongthianhhong.baithuchanh3_flashquizgui {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.bootstrapfx.core;

  opens th.duongthianhhong.baithuchanh3_flashquizgui to javafx.fxml;
  exports th.duongthianhhong.baithuchanh3_flashquizgui;
}