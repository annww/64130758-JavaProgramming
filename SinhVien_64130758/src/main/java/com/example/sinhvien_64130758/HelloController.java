package com.example.sinhvien_64130758;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    public TextField txtmssv, txtname, txtdob;
    public TextArea textresult;

    @FXML
    public void addSV(ActionEvent event){
        String MSSV = txtmssv.getText();
        String HoTen = txtname.getText();
        String NamSinh = txtdob.getText();

        // Tao doi tuong JSON
        JSONObject studentJson = new JSONObject();
        studentJson.put("MSSV", MSSV);
        studentJson.put("Tên",HoTen);
        studentJson.put("Năm sinh", NamSinh);

        // Hien thi
        textresult.setText(studentJson.toJSONString());
    }



}