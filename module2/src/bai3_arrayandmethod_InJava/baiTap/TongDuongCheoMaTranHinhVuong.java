package bai3_arrayandmethod_InJava.baiTap;

import java.util.Scanner;

public class TongDuongCheoMaTranHinhVuong {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập đô dài mảng lớn");
        int mangLon=scanner.nextInt();
        System.out.println("Nhập độ dài mảng nhỏ");
        int mangNho=scanner.nextInt();
        int[][] mang=new int[mangLon][mangNho];
        for (int i = 0; i <mang.length ; i++) {
            for (int j = 0; j <mang[i].length ; j++) {
                System.out.print("Nhập độ phân tử mảng thứ "+mang[i][j]+" ");
                mang[i][j]=scanner.nextInt();
            }
        }

        int sum1=0;
        int sum2=0;
        for (int i = 0; i <mang.length ; i++) {
            for (int j = 0; j <mang[i].length ; j++) {
                if(i==j){
                  sum1+=mang[i][j];
                }
                if(j==mang[i].length-i-1){
                    sum2+=mang[i][j];
                }
            }
        }int sum3=sum1+sum2;
        System.out.println("Tổng 2 đường chéo của ma trận là "+sum3);
    }
}
