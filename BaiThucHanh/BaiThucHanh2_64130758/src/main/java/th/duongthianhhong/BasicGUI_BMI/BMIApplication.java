package th.duongthianhhong.BasicGUI_BMI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BMIApplication extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(BMIApplication.class.getResource("bmi.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Tính BMI!");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}