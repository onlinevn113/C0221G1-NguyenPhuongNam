package method;

import java.util.Scanner;
public class NhapMang1Chieu {
    public static int [] nhapMang (int length){
        int arrNumber[]=new int[length];
        Scanner phanTu=new Scanner(System.in);
        for(int i=0;i<length;i++){
            System.out.println("Nhập vào số thứ "+i);
            int phanTuMang=phanTu.nextInt();
            arrNumber[i]=phanTuMang;
        }
        return arrNumber;
    }
}
