package com.example.qlsv_64130758;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HelloController {
  @FXML
  private Label welcomeText;

  @FXML
  public TextField txtmssv, txtname, txtdob;
  public TextArea textresult;

  @FXML
  private JSONObject getStudentInfo(){
    String MSSV = txtmssv.getText();
    String HoTen = txtname.getText();
    String NamSinh = txtdob.getText();

    // Tao doi tuong JSON
    JSONObject studentJson = new JSONObject();
    studentJson.put("MSSV", MSSV);
    studentJson.put("Tên",HoTen);
    studentJson.put("Năm sinh", NamSinh);
    return studentJson;
  }
  @FXML
  public void addSV(ActionEvent event){
    JSONObject studentJson = getStudentInfo();
    // Hien thi
    textresult.setText(studentJson.toJSONString());
  }

  public void reloadSV(ActionEvent event){
    JSONObject studentJson = getStudentInfo();
  }



  public void saveSV(ActionEvent event){
    JSONObject studentJson = getStudentInfo();

    JSONArray studentArray = new JSONArray();

    File file = new File("student.json");
    System.out.println("Thư mục hiện tại: " + new File(".").getAbsolutePath());

    // Neu file da ton tai thi phan tich du lieu
    if(file.exists()){
      try(FileReader reader = new FileReader(file)){
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse((reader));
        studentArray = (JSONArray) obj;

        // Hien du lieu len textare
        StringBuilder result = new StringBuilder();
        for (Object student : studentArray) {
          result.append(student.toString()).append("\n");
        }
        textresult.setText(result.toString());

      } catch (IOException | ParseException e) {
        textresult.setText("Some error about reading data!" + e.getMessage());
        return;
      }
    }else{
      textresult.setText("Creating a new file");
    }

    studentArray.add(studentJson);

    // update file
    try(FileWriter fileWriter = new FileWriter("student.json")){
      fileWriter.write(studentArray.toJSONString());
      fileWriter.flush();
      textresult.setText("Saved successfully!");
    } catch (IOException e) {
      textresult.setText("Error saving data: " + e.getMessage());
    }
  }
}