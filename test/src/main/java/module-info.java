module daihocnhatrang.duongthianhhong.test {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens daihocnhatrang.duongthianhhong.test to javafx.fxml;
    exports daihocnhatrang.duongthianhhong.test;
}