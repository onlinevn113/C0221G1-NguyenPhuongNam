package bai15_exception_debug.bai_tap;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomExceptionExample {
    static void IllegalTriangle(int a, int b, int c) throws IllegalTriangleException {

        if (a < 0 || b < 0 || c < 0 || a + b < c || a + c < b || b + c < a) {
            throw new IllegalTriangleException("Nhập lại");
        } else {
            System.out.println("Amazing Good Job");
        }
    }

        public static void main(String[] args )  {
        boolean check;
        while (true){
            Scanner scanner=new Scanner(System.in);
            try {
                System.out.println("Nhập accountExample");
                int a=Integer.parseInt( scanner.nextLine());
                System.out.println("Nhập b");
                int b=Integer.parseInt( scanner.nextLine());
                System.out.println("Nhập c");
                int c=Integer.parseInt( scanner.nextLine());
                IllegalTriangle(a,b,c);
                check=false;
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }catch (InputMismatchException e){
                System.out.println("Nhập sai nhập lại số");
            }
        }

    }
}