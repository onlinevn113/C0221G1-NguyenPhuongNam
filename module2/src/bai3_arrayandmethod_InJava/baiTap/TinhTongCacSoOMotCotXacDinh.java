package bai3_arrayandmethod_InJava.baiTap;

import java.util.Scanner;

public class TinhTongCacSoOMotCotXacDinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mảng lớn");
        int mangLon = scanner.nextInt();
        System.out.println("Nhập mảng nhỏ");
        int mangNho = scanner.nextInt();
        int mang2Chieu[][] = new int[mangLon][mangNho];
        for (int i = 0; i < mangLon; i++) {
            for (int j = 0; j < mangNho; j++) {
                System.out.println("arr" + i + "" + j);
                mang2Chieu[i][j] = scanner.nextInt();
            }
        }

       int sum=0;

        for (int i = 0; i <mang2Chieu.length ; i++) {
            for (int j = 0; j <mang2Chieu[i].length ; j++) {
                if(j==0){
                    sum+=mang2Chieu[i][j];
                }
            }
        }
        System.out.println(sum);
    }
}
