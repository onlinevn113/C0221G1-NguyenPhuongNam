package bai3_arrayandmethod_InJava.baiTap;

import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập độ dài");
        int length=scanner.nextInt();
        int[] arr=new int[length];
        int[] arr1=new int[length+1];
        for (int i = 0; i <length; i++) {
            System.out.print("Nhập phần tử vị trí thứ "+i+" ");
            int element=scanner.nextInt();
            arr[i]=element;
        }
        System.out.println("Nhập vị trí muốn thêm ");
        int index=scanner.nextInt();
        System.out.println("Nhập số bạn muốn thêm");
        int num=scanner.nextInt();
        for (int i = 0; i <arr1.length ; i++) {
            if(i==index){
                arr1[index]=num;
            }else if(i>index){
                arr1[i]=arr[i-1];
            }else {
                arr1[i]=arr[i];
            }
        }
        System.out.println(Arrays.toString(arr1));
    }
}
