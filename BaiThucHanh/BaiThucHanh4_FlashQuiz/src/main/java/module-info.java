module th.duongthianhhong.baithuchanh4_flashquiz {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
  requires java.sql;

  opens th.duongthianhhong.baithuchanh4_flashquiz to javafx.fxml;
    exports th.duongthianhhong.baithuchanh4_flashquiz;
}