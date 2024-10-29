module com.example.de2_64130758 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.de2_64130758 to javafx.fxml;
    exports com.example.de2_64130758;
}