package Bai2_loopInJava.baiTap;

import java.util.Scanner;

public class HienThiSoNguyenToDauTien {
    public static boolean kiemTraNguyenTo(double num) {
        boolean check = true;
        if (num < 2) {
            check = false;
        }
            for (int i = 2; i <num; i++) {
                if (num % i == 0) {
                    check = false;
                }
            }
            return check;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int i = 2;
        int n = scanner.nextInt();

        System.out.println(n + " Số nguyên tố đầu tiên là ");

        while (count < n) {
            if (kiemTraNguyenTo(i)) {
                System.out.println(i+" ");
                count++;
            }
            i++;
        }
    }
}
