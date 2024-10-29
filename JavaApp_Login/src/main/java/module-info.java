module com.example.javaapp_login {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires jdk.jdi;
    requires java.desktop;

    opens com.example.javaapp_login to javafx.fxml;
    exports com.example.javaapp_login;
}