package Bai1_introductionJava.thucHanh;

import java.util.Scanner;

public class KiemTraNamNhuan {
    public static void main(String[] args) {
        System.out.println("Enter cac_lop_hinh_hoc year: ");
        Scanner scanner = new Scanner(System.in);
        int year;
        year = scanner.nextInt();
        boolean isLeapYear = false;

        boolean isDivisibleBy4 = year % 4 == 0;
        if(isDivisibleBy4){
            boolean isDivisibleBy100 = year % 100 == 0;
            if(isDivisibleBy100){
                boolean isDivisibleBy400 = year % 400 == 0;
                if(isDivisibleBy400){
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }

        if(isLeapYear){
            System.out.printf("%d is cac_lop_hinh_hoc leap year", year);
        } else {
            System.out.printf("%d is NOT cac_lop_hinh_hoc leap year", year);
        }

    }
}
