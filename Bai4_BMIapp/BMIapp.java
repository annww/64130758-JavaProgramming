package Bai4_BMIapp;

import java.sql.SQLInvalidAuthorizationSpecException;
import java.util.Scanner;

public class BMIapp {
    public static void main(String[] args) {
            //Khai bao bien
        float height, weight, BMI;

        Scanner nhap = new Scanner(System.in);

        System.out.println("------ BMI cua ban la bao nhieuuuuu --------");
        // Nhap chieu cao, can nang
        System.out.print("Nhap chieu cao: ");
        height = nhap.nextFloat();
        System.out.print("Nhap can nang: ");
        weight = nhap.nextFloat();

        // Tinh chi so
        BMI = weight/ (height*height);

        // Dieu kien
        if(BMI > 0){
            if (BMI < 18.5){
                System.out.print(BMI + " thi ban thieu can");
            }
            else if (BMI > 18.5 && BMI < 24.9){
                System.out.print(BMI + " thi ban binh thuong");
            }
            else if (BMI > 25 && BMI < 29.9){
                System.out.print(BMI + " thi ban thua can");
            }
            else System.out.print(BMI + " thi ban beo phi");
        }

    }
}