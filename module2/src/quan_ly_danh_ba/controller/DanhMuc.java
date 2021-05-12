package quan_ly_danh_ba.controller;

import java.util.Scanner;

public class DanhMuc {
 
    public static void quanLyDanhBa() {
        Scanner scanner = new Scanner(System.in);
        String chon;
        while (true) {
            System.out.print("CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ:" +
                    "CHỌN CHỨC NĂNG THEO SỐ(ĐỂ TIẾP TỤC):\n" +
                    "1 XEM DANH SÁCH\n" +
                    "2 THÊM MỚI\n" +
                    "3 CẬP NHẬT\n" +
                    "4 XOÁ\n" +
                    "5 TÌM KIẾM\n" +
                    "6 THOÁT\n");
            System.out.print("Chọn chức năng: ");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    QuanLyChucNang.xemDanhSach();
                    break;
                case "2":
                    QuanLyChucNang.themMoi();
                    break;
                case "3":
                    QuanLyChucNang.capNhat();
                    break;
                case "4":
                    QuanLyChucNang.xoa();
                    break;
                case "5":
                    QuanLyChucNang.timKiem();
                    break;
                case "6":
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn theo danh mục , chon tu 1-6");
            }
        }
    }
}
