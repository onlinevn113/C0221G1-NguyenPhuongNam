package bai3_arrayandmethod_InJava.baiTap;

import java.util.Scanner;

public class TimPhanTuLonNhatTrongMang2Chieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mảng lớn");
        int mangLon = scanner.nextInt();
        System.out.println("Nhập mảng nhỏ");
        int mangNho = scanner.nextInt();
        int mang[][] = new int[mangLon][mangNho];
        for (int i = 0; i < mangLon; i++) {
            for (int j = 0; j < mangNho; j++) {
                System.out.println("arr" + i + "" + j);
                mang[i][j] = scanner.nextInt();
            }
        }

        
        int max = mang[0][0];
        for (int[] i : mang) {
            for (int j : i) {
                System.out.print(j);
                if(j>max){

                    max=j;

                }
            }


        }
        System.out.println("\n"+"Phần tử lớn nhất là "+max);
    }
}
