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
        while(true){
            System.out.print("Nhap chieu cao: ");
            try {
                height = nhap.nextFloat();
                if(height >= 1.0f && height <= 2.2f){
                    break;
                }
                else{
                    System.out.println("Chieu cao phai tu 1.0 den 2.2");
                }
            } catch (Exception e) {
                System.out.print("Hay nhap vao mot so: ");
                nhap.next();
            }
        }
        while(true){
            System.out.print("Nhap can nang: ");
            try{
                weight = nhap.nextFloat();
                if(weight > 0 && weight < 200){
                    break;
                }
                else{
                    System.out.println("Can nang phai tu 0kg den 200kg");
                }
            } catch (Exception e){
                System.out.println("Hay nhap vao mot so: ");
                nhap.next();
            }
        }
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
