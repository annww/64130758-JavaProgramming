package thigk.de2.de2_cau3_64130758;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class mainClass extends Application {
  public mainClass() {
  }

  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(mainClass.class.getResource("mathquiz.fxml"));
    Scene scene = new Scene((Parent)fxmlLoader.load());
    stage.setTitle("MathQuiz");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(new String[0]);
  }
}

