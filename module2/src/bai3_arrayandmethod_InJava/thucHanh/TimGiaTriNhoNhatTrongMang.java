package bai3_arrayandmethod_InJava.thucHanh;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input n");
        int n = sc.nextInt();
        int[] arr;
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Elenment" + (i + 1) + ",");
            arr[i] = sc.nextInt();
        }
        int index = minvalue(arr);
        System.out.println("vị trí của phần tử nhỏ nhất trong mảng :" + index);
        System.out.println("giá trị nhỏ nhất là :" + arr[index]);
    }

    public static int minvalue(int[] array) {
        int min = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }

}
