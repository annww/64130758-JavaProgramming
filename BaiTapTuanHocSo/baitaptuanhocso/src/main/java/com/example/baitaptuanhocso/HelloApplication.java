package com.example.baitaptuanhocso;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
      // Tao canvas
      Canvas canvas = new Canvas(400, 400);
      GraphicsContext gc = canvas.getGraphicsContext2D();

      // Ve hinh tron
      gc.setStroke(Color.BLACK);
      gc.strokeOval(150, 150, 100, 100);

      // Them vao scene
      Group root = new Group(canvas);
      Scene scene = new Scene(root, 400, 400);
      stage.setTitle("Bai tap ve bang JavaFX");
      stage.setScene(scene);
      stage.show();

  }

  public static void main(String[] args) {
    launch();
  }
}