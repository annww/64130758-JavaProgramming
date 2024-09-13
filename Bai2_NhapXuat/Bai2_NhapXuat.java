package Bai2;

import java.util.Scanner;

class Bai2_NhapXuat{
    public static void main(String[] args) {
        // Khai bao du lieu
        int a, b, tong;
        // Chuan bi cho nhap du lieu
        Scanner banPhim =new Scanner(System.in);
        // Nhap du lieu
            // B1: In huong dan cho user
            System.out.println("----- CT TINH TONG 2 SO NGUYEN");
            System.out.print("a = ");
            // doi user nhap lay du lieu va cat vao bien a
            a = banPhim.nextInt();
            System.out.print("b = ");
            // doi user nhap lay du lieu va cat vao bien b
            b = banPhim.nextInt();
            // Tinh tong
            tong = a + b;
            System.out.print("Tong = " + tong);
    }
}