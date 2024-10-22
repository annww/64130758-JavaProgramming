module com.example.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
  requires java.xml;

  opens com.example.tictactoe to javafx.fxml;
    exports com.example.tictactoe;
}