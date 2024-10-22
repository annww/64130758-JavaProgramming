module com.example.demobanhang_64130758 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
  requires java.sql;

  opens com.example.demobanhang_64130758 to javafx.fxml;
    exports com.example.demobanhang_64130758;
}