package Bai6_Kethua_Inheritance_Dahinh_Abstraction.baiTap.ClassCircle_andclassCylinder;

import java.util.Scanner;

public class MainCylinder {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập bán kính");
        int radius=scanner.nextInt();
        System.out.println("Nhập chiều cao");
        int h=scanner.nextInt();
        Circle circle=new Circle();
        Cylinder cylinder=new Cylinder(radius,"Blue",h);
        System.out.println(cylinder.toString());
    }
}
