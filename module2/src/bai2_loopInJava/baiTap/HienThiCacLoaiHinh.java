package Bai2_loopInJava.baiTap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        System.out.println("Danh Sach ");
        System.out.println("1. Hinh chu nhat ");
        System.out.println("2. Tam giac vuong tren trai ");
        System.out.println("3. Tam giac vuong duoi trai ");
        System.out.println("4. Thoat ");
        int chon = scanner.nextInt();
        do {
            System.out.println("nhap vao chieu dai canh : ");
            n = scanner.nextInt();


            switch (chon) {
                case 1:

                    for (int i = 1; i <= n; i++) {
                        for (int k = 1; k <= n; k++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;


                case 2:

                    for (int i = 1; i <= n; i++) {
                        for (int k = 1; k <= i; k++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }

                    break;


                case 3:

                    for (int i = 1; i <= n; i++) {
                        for (int k = 1; k <= n; k++) {
                            if (k <= n - i) {
                                System.out.print(" ");
                            } else {
                                System.out.print("*");
                            }
                        }
                        System.out.print("\n");
                    }

                    break;


                default:
                    System.out.println("khong co trong danh sach!");
                    System.out.println("chon lai :");
                    break;


            }
            chon = scanner.nextInt();

        } while (chon != 4);

    }
}
