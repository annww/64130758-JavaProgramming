module daihocnhatrang.duongthianhhong.baithuchanh1_641308758 {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.bootstrapfx.core;

  opens th.duongthianhhong.SimpleMath to javafx.fxml;
  exports th.duongthianhhong.SimpleMath;
}