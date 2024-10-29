package com.example.de2_cau2_64130758;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private static Stage primaryStage;

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        setPrimaryStage(stage);
        showHelloScene();
    }

    public static void showHelloScene() throws IOException {
        Parent root = FXMLLoader.load(MainApp.class.getResource("hello-view.fxml"));
        primaryStage.setTitle("Đăng nhập");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void showMainAppScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("danhSachHS.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Danh Sách Học Sinh");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
