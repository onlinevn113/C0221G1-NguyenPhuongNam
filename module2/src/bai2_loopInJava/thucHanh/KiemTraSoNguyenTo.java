package Bai2_loopInJava.thucHanh;

import java.util.Scanner;

public class KiemTraSoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter controllers number:");
        int number = scanner.nextInt();
        if (number < 2)
            System.out.println(number + " is not controllers prime");
        else {
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check)
                System.out.println(number + " is controllers prime");
            else
                System.out.println(number + " is not controllers prime");
        }
    }
}
