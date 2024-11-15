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
      gc.strokeOval(150, 130, 100, 100);

      // Ve hinh tam giac lon
      gc.setLineWidth(2);
      gc.setFill(Color.WHITE);
      double[] X_position = {100,200,300};
      double[] Y_position = {180,100,180};
      gc.strokePolygon(X_position,Y_position,3);
      gc.fillPolygon(X_position,Y_position,3);

      // Ve tam giac nho 1
      gc.setLineWidth(2);
      gc.setFill(Color.WHITE);
      double[] X1 = {175,190,175};
      double[] Y1 = {95,107,120};
      gc.strokePolygon(X1,Y1,3);
      gc.fillPolygon(X1,Y1,3);

      // Ve tam giac nho 2
      gc.setLineWidth(2);
      gc.setFill(Color.WHITE);
      double[] X2 = {210,225,225};
      double[] Y2 = {107,95,120};
      gc.strokePolygon(X2,Y2,3);
      gc.fillPolygon(X2,Y2,3);

      // Ve cai mom mau do
      gc.setLineWidth(2);
      gc.setStroke(Color.RED);
      double[] X_red = {185,215,200};
      double[] Y_red = {155,155,165};
      gc.strokePolygon(X_red,Y_red,3);
      gc.fillPolygon(X_red,Y_red,3);

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