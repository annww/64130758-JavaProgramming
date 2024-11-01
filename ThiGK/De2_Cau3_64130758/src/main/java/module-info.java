module com.example.de2_cau3_64130758 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens thigk.de2.de2_cau3_64130758 to javafx.fxml;
    exports thigk.de2.de2_cau3_64130758;
}