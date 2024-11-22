module daihocnhatrang.duongthianhhong.demobh {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
  requires java.sql;

  opens daihocnhatrang.duongthianhhong to javafx.fxml;
    exports daihocnhatrang.duongthianhhong;
}