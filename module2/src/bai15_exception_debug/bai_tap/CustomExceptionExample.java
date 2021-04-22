package bai15_exception_debug.bai_tap;

import java.util.Scanner;

public class CustomExceptionExample {
    static void IllegalTriangle(int a,int b,int c)throws IllegalTriangleException{

            if (a<0||b<0||c<0||a+b<c||a+c<b||b+c<a){
                throw new IllegalTriangleException("a,b,c"     );
            }else{
                System.out.println("Amazing Good Job");
            }
    }

    public static void main(String[] args )  {
        boolean check;
        while (true){
            Scanner scanner=new Scanner(System.in);
            System.out.println("Nhập a");
            int a=scanner.nextInt();
            System.out.println("Nhập b");
            int b=scanner.nextInt();
            System.out.println("Nhập c");
            int c=scanner.nextInt();
            try {
                IllegalTriangle(a,b,c);
                check=false;
                break;
            } catch (Exception e) {
//                System.out.println("Lỗi "+e);
                System.out.println(e.getMessage());
            }
        }

    }
}
