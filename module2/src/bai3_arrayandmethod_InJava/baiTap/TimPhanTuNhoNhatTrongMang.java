package bai3_arrayandmethod_InJava.baiTap;

import java.util.Scanner;

public class TimPhanTuNhoNhatTrongMang {
    public static void main(String[] args) {
        System.out.println("Nhập độ dài mảng");
        Scanner scanner=new Scanner(System.in);
        int [] mang=GopMang.nhapMang(scanner.nextInt());
        int min=mang[0];
        for (int i:mang) {
            if(min>i){
                min=i;
            }
        }
        System.out.println("Phần tử nhỏ nhất là "+min);
    }
}
