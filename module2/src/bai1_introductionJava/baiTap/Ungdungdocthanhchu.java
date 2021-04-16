package bai1_introductionJava.baiTap;

import java.util.Scanner;

public class Ungdungdocthanhchu {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập số cần đọc : ");
            int number = Integer.parseInt(scanner.nextLine());
            String[] arrayLessNum20 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
            String[] arrayMoreNum20 = {"twenty", "thirty", "forty", "fifty", "sixties", "seventies", "eighty", "ninety"};
            String strNum = "";
            if (number < 20) {
                strNum = arrayLessNum20[number];
            } else {
                if (number < 100) {
                    strNum += arrayMoreNum20[number / 10 - 2];
                    strNum += " " + arrayLessNum20[number % 10];
                } else {
                    strNum += arrayLessNum20[number / 100] + " hundred ";
                    if ((number % 100) > 20) {
                        strNum += arrayMoreNum20[(number % 100) / 10 - 2];
                        strNum += " " + arrayLessNum20[number % 10];
                    } else if (number % 100 == 0) {
                    } else {
                        strNum += arrayLessNum20[number % 100];
                    }
                }
            }
            System.out.println(number + " read : " + strNum);
        }
    }
}