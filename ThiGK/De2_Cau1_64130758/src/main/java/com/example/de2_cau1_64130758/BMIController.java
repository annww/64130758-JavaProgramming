package com.example.de2_cau1_64130758;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BMIController {

    @FXML
    private TextField txtChieuCao; // Chiều cao
    @FXML
    private TextField txtCanNang;   // Cân nặng
    @FXML
    private Label lbKQ;             // Kết quả BMI
    @FXML
    private TextField txtByte;       // Input cho byte

    private ArrayList<String> history = new ArrayList<>();

    @FXML
    private void kiemTra() {
        try {
            double chieuCao = Double.parseDouble(txtChieuCao.getText());
            double canNang = Double.parseDouble(txtCanNang.getText());

            // Tính BMI
            double bmi = canNang / (chieuCao * chieuCao);
            lbKQ.setText(String.format("%.2f", bmi));

            // Ghi vào lịch sử
            String result = String.format("Cân nặng: %.2f kg, Chiều cao: %.2f m, BMI: %.2f", canNang, chieuCao, bmi);
            addToHistory(result);
        } catch (NumberFormatException e) {
            lbKQ.setText("Vui lòng nhập số hợp lệ!");
        }
    }

    @FXML
    private void resetFields() {
        txtChieuCao.clear();
        txtCanNang.clear();
        lbKQ.setText("...........");
    }

    @FXML
    private void convertByteToBit() {
        try {
            double byteValue = Double.parseDouble(txtByte.getText());
            double bitValue = byteValue * 8; // 1 byte = 8 bits
            lbKQ.setText(String.format("%.2f bit", bitValue));
        } catch (NumberFormatException e) {
            lbKQ.setText("Vui lòng nhập số hợp lệ!");
        }
    }

    private void addToHistory(String result) {
        history.add(result);
        if (history.size() > 10) {
            history.remove(0); // Giữ lại 10 lệnh gần nhất
        }
        writeHistoryToFile();
    }

    private void writeHistoryToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            for (String entry : history) {
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
