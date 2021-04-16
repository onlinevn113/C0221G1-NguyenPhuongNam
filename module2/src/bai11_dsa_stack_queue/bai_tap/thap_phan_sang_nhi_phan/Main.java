package bai11_dsa_stack_queue.bai_tap.thap_phan_sang_nhi_phan;

import java.util.Scanner;



public class Main extends DaoNguocChuoi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập số cần kiểm tra nhị phân ");
        int number=scanner.nextInt();

        String t =  ThapPhanSangNhiPhan.thapPhanSangNhiPhan(number);
        StringBuilder k = new StringBuilder(t);

        System.out.print(number+" chuyển sang nhị phân là: " );
        DaoNguocChuoi.reverse(k);


    }
}
