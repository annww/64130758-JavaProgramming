module th.duongthianhhong.th_bai5_simpledict {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens th.duongthianhhong.th_bai5_simpledict to javafx.fxml;
    exports th.duongthianhhong.th_bai5_simpledict;
}