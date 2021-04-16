package bai3_arrayandmethod_InJava.baiTap;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static int[] nhapMang(int length) {
        int arrNumber[] = new int[length];
        Scanner phanTu = new Scanner(System.in);
        for (int i = 0; i < length; i++) {
            System.out.println("Nhập vào số thứ " + i);
            int phanTuMang = phanTu.nextInt();
            arrNumber[i] = phanTuMang;
        }
        return arrNumber;
    }

    public static void main(String[] args) {
        System.out.println("Nhap do dai mang1");
        Scanner doDaiMang = new Scanner(System.in);
        int[] mang1 = nhapMang(doDaiMang.nextInt());
        System.out.println("Nhap do dai mang2");
        int doDaiMang2=doDaiMang.nextInt();
        int[] mang2 = nhapMang(doDaiMang2);
        int[] mang3 = new int[mang1.length + mang2.length];





        for (int i = 0; i < mang1.length; i++) {
            mang3[i] = mang1[i];
        }
        for (int i = 0; i < mang2.length; i++) {
            mang3[i + mang1.length] = mang2[i];
        }
        System.out.println(Arrays.toString(mang3));
    }

}

