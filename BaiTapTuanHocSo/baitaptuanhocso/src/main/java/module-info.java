module com.example.baitaptuanhocso {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.bootstrapfx.core;

  opens com.example.baitaptuanhocso to javafx.fxml;
  exports com.example.baitaptuanhocso;
}