module com.example.sinhvien_64130758 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
  requires json.simple;

  opens com.example.sinhvien_64130758 to javafx.fxml;
    exports com.example.sinhvien_64130758;
}