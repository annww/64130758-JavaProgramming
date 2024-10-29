package com.example.javaapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    public TextField num1;
    public TextField num2;
    @FXML
    Button btnaddition, btnsubtraction, btnmultiplication, btndivision, btnsquareroot, btnsin, btncos, btnex, btnln, btnlog;
    @FXML
    public Label labelresult;

    @FXML
    public void tinhTong(){
        double n1 = Double.parseDouble(String.valueOf(num1.getText()));
        double n2 = Double.parseDouble(String.valueOf(num2.getText()));
        labelresult.setText(String.valueOf(n1 + n2));
    }
    public void tinhHieu(){
        double n1 = Double.parseDouble(String.valueOf(num1.getText()));
        double n2 = Double.parseDouble(String.valueOf(num2.getText()));
        labelresult.setText(String.valueOf(n1 - n2));
    }
    public void Nhan(){
        double n1 = Double.parseDouble(String.valueOf(num1.getText()));
        double n2 = Double.parseDouble(String.valueOf(num2.getText()));
        labelresult.setText(String.valueOf(n1 * n2));
    }
    public void Chia(){
        double n1 = Double.parseDouble(String.valueOf(num1.getText()));
        double n2 = Double.parseDouble(String.valueOf(num2.getText()));
        labelresult.setText(String.valueOf(n1 / n2));
    }
    public void Can(){
        double n1 = Double.parseDouble(String.valueOf(num1.getText()));
        double n2 = Double.parseDouble(String.valueOf(num2.getText()));
        if(n2 != 0){
            labelresult.setText(String.valueOf(Math.pow(n1,1/n2)));
        }
        else labelresult.setText("Invalid number");
    }
    public void Sin(){
        double n = Double.parseDouble(String.valueOf(num1.getText()));
        labelresult.setText(String.valueOf(Math.sin(n)));
    }
    public void Cos(){
        double n = Double.parseDouble(String.valueOf(num1.getText()));
        labelresult.setText(String.valueOf(Math.cos(n)));
    }
    public void Ex(){
        double n = Double.parseDouble(String.valueOf(num1.getText()));
        labelresult.setText(String.valueOf(Math.exp(n)));
    }
    public void ln(){
        double num = Double.parseDouble(String.valueOf(num1.getText()));
        if(num > 0){
            labelresult.setText(String.valueOf(Math.log(num)));
        }
        else {
            labelresult.setText("Invalid input for N");
        }
    }
    public void log(){
        double num = Double.parseDouble(String.valueOf(num1.getText()));
        if(num > 0){
            labelresult.setText(String.valueOf(Math.log10(num)));
        }
        else {
            labelresult.setText("Invalid input for N");
        }
    }

}