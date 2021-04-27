package bai19_.bai_tap.regular_class_name;

import java.util.Scanner;
public class RegularExpression {
    public static final  String NAME_REGEX = "^[CAP]\\d{4}[GHIKLM]$";
    public static final  String NAME_REGEX1 = "^[CAP]\\d{4}[GHIKLM]\\d{1}$";
    public static void main(String[] args) {
        System.out.println("Nhập tên lớp muốn kiểm tra");
        String a=new Scanner(System.in).nextLine();
        System.out.println(a.trim().matches(NAME_REGEX1));


    }
}
