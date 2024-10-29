package com.example.de2_cau2_64130758;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class danhSachHSController {
  @FXML
  private AnchorPane root;
  @FXML
  private TableView<Student> studentTable;
  @FXML
  private TableColumn<Student, String> nameColumn;
  @FXML
  private TableColumn<Student, Integer> ageColumn;
  @FXML
  private TableColumn<Student, String> classColumn;

  @FXML
  private TextField nameField;
  @FXML
  private TextField ageField;
  @FXML
  private TextField classField;

  private ObservableList<Student> studentList = FXCollections.observableArrayList();

  private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }

  @FXML
  public void initialize() {
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
    classColumn.setCellValueFactory(cellData -> cellData.getValue().classProperty());
    studentTable.setItems(studentList);
    loadStudentsFromDatabase();
  }

  @FXML
  public void addStudent() {
    String name = nameField.getText();
    String ageText = ageField.getText();
    String studentClass = classField.getText();

    // Kiểm tra trường nhập
    if (name.isEmpty() || ageText.isEmpty() || studentClass.isEmpty()) {
      showAlert("Lỗi", "Tất cả các trường phải được điền.");
      return;
    }

    // Kiểm tra tuổi
    int age;
    try {
      age = Integer.parseInt(ageText);
    } catch (NumberFormatException e) {
      showAlert("Lỗi", "Tuổi phải là một số hợp lệ.");
      return;
    }

    Student newStudent = new Student(name, age, studentClass);
    studentList.add(newStudent);
    if (addStudentToDatabase(newStudent)) {
      clearFields();
      showAlert("Thông báo", "Đã thêm sinh viên thành công.");
    } else {
      showAlert("Lỗi", "Không thể thêm sinh viên vào cơ sở dữ liệu.");
    }
  }

  @FXML
  public void editStudent() {

    Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();

    if (selectedStudent == null) {
      showAlert("Lỗi", "Vui lòng chọn một sinh viên để chỉnh sửa.");
      return;
    }

    String name = nameField.getText().trim();
    String ageText = ageField.getText().trim();
    String className = classField.getText().trim();

    if (name.isEmpty() || ageText.isEmpty() || className.isEmpty()) {
      showAlert("Lỗi", "Tất cả các trường phải được điền.");
      return;
    }

    int age;
    try {
      age = Integer.parseInt(ageText);
    } catch (NumberFormatException e) {
      showAlert("Lỗi", "Tuổi phải là một số hợp lệ.");
      return;
    }

    // Cập nhật thông tin sinh viên
    selectedStudent.setName(name);
    selectedStudent.setAge(age);
    selectedStudent.setClassName(className);
    studentTable.refresh();
    updateStudentInDatabase(selectedStudent);
    clearFields();
    showAlert("Thông báo", "Đã cập nhật sinh viên thành công.");
  }

  private void clearFields() {
    nameField.clear();
    ageField.clear();
    classField.clear();
  }

  public class DatabaseHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/hocsinh";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection getConnection() {
      try {
        return DriverManager.getConnection(URL, USER, PASSWORD);
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    }
  }

  public boolean addStudentToDatabase(Student student) {
    String query = "INSERT INTO hocsinh (name, age, class) VALUES (?, ?, ?)";
    try (Connection connection = new DatabaseHandler().getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setString(1, student.getName());
      statement.setInt(2, student.getAge());
      statement.setString(3, student.getClassName());
      statement.executeUpdate();
      return true; // Thêm thành công
    } catch (Exception e) {
      e.printStackTrace();
      return false; // Thêm thất bại
    }
  }

  public void loadStudentsFromDatabase() {
    String query = "SELECT * FROM hocsinh";
    try (Connection connection = new DatabaseHandler().getConnection();
         PreparedStatement statement = connection.prepareStatement(query);
         ResultSet resultSet = statement.executeQuery()) {

      while (resultSet.next()) {
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String studentClass = resultSet.getString("class");
        studentList.add(new Student(name, age, studentClass));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void deleteStudentFromDatabase(Student student) {
    String query = "DELETE FROM hocsinh WHERE name = ? AND age = ? AND class = ?";
    try (Connection connection = new DatabaseHandler().getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setString(1, student.getName());
      statement.setInt(2, student.getAge());
      statement.setString(3, student.getClassName());
      statement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @FXML
  public void deleteStudent() {
    Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
    if (selectedStudent != null) {
      studentList.remove(selectedStudent);
      deleteStudentFromDatabase(selectedStudent);
      showAlert("Thông báo", "Đã xóa sinh viên thành công.");
    } else {
      showAlert("Lỗi", "Vui lòng chọn một sinh viên để xóa.");
    }
  }

  public void updateStudentInDatabase(Student student) {
    String query = "UPDATE hocsinh SET age = ?, class = ? WHERE name = ?";
    try (Connection connection = new DatabaseHandler().getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setInt(1, student.getAge());
      statement.setString(2, student.getClassName());
      statement.setString(3, student.getName());
      statement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
