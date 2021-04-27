package bai19_.bai_tap.regex_phone_number;

import java.util.Scanner;

public class ValidatePhoneNumber {
    public static void main(String[] args) {
        String phoneRegex = "^[(][0-9]{2}[)][-][(][0][0-9]{9}[)]$";
        String phoneRegex1 = "^[(][0-9]{2}[)]-[(][0-9]{9}[)]$";


        System.out.println("Nhập số điện thoại muốn kiểm tra");
        String phoneNumber = new Scanner(System.in).nextLine();
        System.out.println(phoneNumber.trim().matches(phoneRegex));
    }
}
