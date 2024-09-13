package Bai3_OddEvenApp;

import java.sql.SQLInvalidAuthorizationSpecException;
import java.util.Scanner;

public class Bai3_OddEvenApp {
    public static void main(String[] args) {
        int a;
        Scanner nhap = new Scanner(System.in); // Nhap chan le
        //Nhap 1 so
        System.out.println("Nhap a: ");
        a = nhap.nextInt();

        // Kiem tra dieu kien chan le
        if(a % 2 == 0){
            System.out.println(a + " la so chan!!!!");
        } else{
            System.out.println(a + " la so le!!!");
        }   
    }
}

