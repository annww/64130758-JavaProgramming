package com.example.demobanhang_64130758;

import java.sql.*;

public class Home {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
//    System.out.printf("Hello");
    // dang ky driver
    Class.forName("com.mysql.cj.jdbc.Driver");
    // 2. Mo ket noi
    // 2.1 Tao chuoi ket noi
    String strCont = "jdbc:mysql://localhost:3306/demobanhang";
    Connection conn = DriverManager.getConnection(strCont,"root","");
    System.out.printf("Haha \n");

    //Select
    String sqlSelect = "select * from sanpham";
    Statement Lenh = conn.createStatement();
    ResultSet ketQua = Lenh.executeQuery(sqlSelect);
    //Hien ket qua
    while(ketQua.next()){
      int id = ketQua.getInt(1); // Lay du lieu tu cot 0
      String tenSP = ketQua.getString(2);// Lay du lieu tu cot 1
      String giaSP = ketQua.getString(3);//Lay du lieu tu cot 2
      String moTa = ketQua.getString(4);// Lay du lieu tu cpt 3
      System.out.println("ID: " + id + " | " + "Ten san pham: " + tenSP + " | " + "Gia san pham: " + giaSP + " | " + "Mo ta: " + moTa);
    }
  }
}
