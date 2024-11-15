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
  }

  public static void main(String[] args) {
    launch();
  }
}