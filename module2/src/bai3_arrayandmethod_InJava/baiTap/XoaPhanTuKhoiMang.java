package bai3_arrayandmethod_InJava.baiTap;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        System.out.println("Nhập độ dài mảng");
        Scanner scanner=new Scanner(System.in);
        int [] arr=GopMang.nhapMang(scanner.nextInt());
        System.out.println("Nhập phần tử bạn muốn xóa");
        int n = scanner.nextInt();
//        for (int i=0;i<arr.length;i++){
//            if (arr[i] == n ){
//                for(int j = i ; j<arr.length -1 ; j++){
//                    arr[j] = arr[j +1 ];
//                }
//            }
//        }
        for (int i = n; i <arr.length-1 ; i++) {
            arr[i]=arr[i+1];
        }

        System.out.println("Mãng mới là : ");

        for (int j = 0 ; j < arr.length - 1; j ++){
            System.out.print(arr[j] + "\t");
        }

    }
}
