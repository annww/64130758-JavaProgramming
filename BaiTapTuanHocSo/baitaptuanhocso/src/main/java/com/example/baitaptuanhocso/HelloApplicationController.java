package com.example.baitaptuanhocso;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class HelloApplicationController {

  @FXML
  private Canvas canvas;

  @FXML
  private Button drawButton;

  private GraphicsContext gc;

  @FXML
  public void initialize() {
    // Lấy đối tượng GraphicsContext từ Canvas để vẽ
    gc = canvas.getGraphicsContext2D();

    // Gán sự kiện cho nút để vẽ hình tại vị trí cố định
    drawButton.setOnAction(e -> drawShapes(150, 130));

    // Gán sự kiện nhấp chuột để vẽ hình tại vị trí nhấp chuột
    canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
      double x = event.getX() - 50; // Điều chỉnh toạ độ để căn giữa hình
      double y = event.getY() - 50;
      gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); // Xoá Canvas trước khi vẽ
      drawShapes(x, y);
    });
  }

  // Phương thức vẽ hình
  private void drawShapes(double x, double y) {
    // Vẽ hình tròn
    gc.setLineWidth(2);
    gc.setStroke(Color.BLACK);
    gc.strokeOval(x, y, 100, 100);
    gc.setFill(Color.WHITE);
    gc.fillOval(x, y, 100, 100);

    // Vẽ tam giác lớn
    gc.setLineWidth(2);
    gc.setFill(Color.WHITE);
    double[] X_position = {x - 50, x + 50, x + 150};
    double[] Y_position = {y + 50, y - 30, y + 50};
    gc.strokePolygon(X_position, Y_position, 3);
    gc.fillPolygon(X_position, Y_position, 3);

    // Vẽ tam giác nhỏ 1
    double[] X1 = {x + 25, x + 40, x + 25};
    double[] Y1 = {y - 35, y - 23, y - 10};
    gc.strokePolygon(X1, Y1, 3);
    gc.fillPolygon(X1, Y1, 3);

    // Vẽ tam giác nhỏ 2
    double[] X2 = {x + 60, x + 75, x + 75};
    double[] Y2 = {y - 23, y - 35, y - 10};
    gc.strokePolygon(X2, Y2, 3);
    gc.fillPolygon(X2, Y2, 3);

    // Vẽ cái mỏ màu đỏ
    gc.setStroke(Color.RED);
    double[] X_red = {x + 35, x + 65, x + 50};
    double[] Y_red = {y + 25, y + 25, y + 35};
    gc.strokePolygon(X_red, Y_red, 3);
    gc.fillPolygon(X_red, Y_red, 3);

    // Vẽ chân trái
    gc.setStroke(Color.BLACK);
    gc.strokeOval(x + 20, y + 90, 20, 20);
    gc.fillOval(x + 20, y + 90, 20, 20);

    // Vẽ chân phải
    gc.setStroke(Color.BLACK);
    gc.strokeOval(x + 60, y + 90, 20, 20);
    gc.fillOval(x + 60, y + 90, 20, 20);

    // Vẽ đường cong bên trong chân trái
    gc.setStroke(Color.RED);
    gc.strokeArc(x + 22, y + 100, 5, 10, 90, 180, javafx.scene.shape.ArcType.OPEN);
    gc.strokeArc(x + 32, y + 100, 5, 10, 90, -180, javafx.scene.shape.ArcType.OPEN);

    // Vẽ đường cong bên trong chân phải
    gc.setStroke(Color.RED);
    gc.strokeArc(x + 62, y + 100, 5, 10, 90, 180, javafx.scene.shape.ArcType.OPEN);
    gc.strokeArc(x + 72, y + 100, 5, 10, 90, -180, javafx.scene.shape.ArcType.OPEN);
  }
}
