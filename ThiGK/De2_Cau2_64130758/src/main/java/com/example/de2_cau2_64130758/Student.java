package com.example.de2_cau2_64130758;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
  private final StringProperty name;
  private final SimpleIntegerProperty age;
  private final StringProperty className;

  public Student(String name, int age, String className) {
    this.name = new SimpleStringProperty(name);
    this.age = new SimpleIntegerProperty(age);
    this.className = new SimpleStringProperty(className);
  }

  public String getName() {
    return name.get();
  }

  public StringProperty nameProperty() {
    return name;
  }

  public int getAge() {
    return age.get();
  }

  public SimpleIntegerProperty ageProperty() {
    return age;
  }

  public String getClassName() {
    return className.get();
  }

  public StringProperty classProperty() {
    return className;
  }

  public void setName(String name) {
    this.name.set(name);
  }

  public void setAge(int age) {
    this.age.set(age);
  }

  public void setClassName(String className) {
    this.className.set(className);
  }
}