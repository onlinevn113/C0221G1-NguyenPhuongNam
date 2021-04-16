package bai3_arrayandmethod_InJava.baiTap;

import java.util.Scanner;

public class DemSoLanXuatHienTrongChuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao chuoi ki tu : ");
        String chuoi=scanner.nextLine();
        char[] mang =chuoi.toCharArray();
        System.out.print("Nhap vao ki tu can kiem tra :");
        char kiTu=scanner.nextLine().charAt(0);

        int count=0;
        int i;
        for (i=0; i< mang.length ; i++){
            if (mang[i]==kiTu){
                count++;
            }
        }
        System.out.println("So la xuat hien cua ki tu "+kiTu+" la : "+count);
    }
}
