package quan_ly_phuong_tien.controller;

import quan_ly_phuong_tien.model.Oto;
import quan_ly_phuong_tien.model.XeMay;
import quan_ly_phuong_tien.model.XeTai;

import java.util.Scanner;

public class QuanLyPhuongTien {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        String choice;
        do {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG\n" +
                    "Chọn chức năng:\n" +
                    "1. Thêm mới phương tiện.\n" +
                    "2. Hiện thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Thoát\n" +
                    "5. Sửa đổi phương tiện");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    themMoiPhuongTien();
                    break;
                case "2":
                    hienThiPhuongTien();
                    break;
                case "3":
                    xoaPhuongTien();
                    break;
                case "4":
                    System.out.println("Tạm biệt");
                    System.exit(0);
                    break;
                case "5":
                    suaDoiPhuongTien();
                    break;
                default:
                    System.out.println("Chọn theo chức năng từ 1-4");
            }
        } while (choice != "4");


    }

    private static void suaDoiPhuongTien() {
        
    }

    private static void xoaPhuongTien() {
        String choice;
        QuanLyChucNang quanLyChucNang = new QuanLyChucNang();
        do {
            System.out.println("Chọn loại xe cần xoá\n" +
                    "1. xe tải,\n" +
                    "2. ôtô, \n" +
                    "3. xe máy.\n" +
                    "4. Trở về\n" +
                    "5. Thoát");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    quanLyChucNang.xoaXeTai();
                    break;
                case "2":
                    quanLyChucNang.xoaOto();
                    break;
                case "3":
                    quanLyChucNang.xoaXemay();
                    break;
                case "4":
                    return;
                case "5":
                    System.out.println("Tạm biệt");
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn từ 1-5");
            }
        } while (choice != "5");

    }

    private static void hienThiPhuongTien() {
        String choice;
        QuanLyChucNang quanLyChucNang = new QuanLyChucNang();
        do {
            System.out.println("Chọn loại xe cần hiển thị\n" +
                    "1. Hiển thị xe tải,\n" +
                    "2. Hiển thị ôtô, \n" +
                    "3. Hiển thị  xe máy.\n" +
                    "4. Trở về\n" +
                    "5. Thoát\n" +
                    "6. Hiển thị tất cả");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    quanLyChucNang.hienThiXeTai();
                    break;
                case "2":
                    quanLyChucNang.hienThiXeOto();
                    break;
                case "3":
                    quanLyChucNang.hienThiXeMay();
                    break;
                case "4":
                    return;
                case "5":
                    System.out.println("Tạm biệt");
                    System.exit(0);
                case "6":
                    quanLyChucNang.hienThiTatCa();
                default:
                    System.out.println("Vui lòng chọn từ 1-5");

            }
        } while (choice != "5");
    }


    private static void themMoiPhuongTien() {
        String choice;
        QuanLyChucNang quanLyChucNang = new QuanLyChucNang();
        do {
            System.out.println("Chọn loại xe cần thêm mới\n" +
                    "1. Thêm xe tải,\n" +
                    "2. Thêm ôtô, \n" +
                    "3. Thêm  xe máy.\n" +
                    "4. Trở về\n" +
                    "5. Thoát");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    quanLyChucNang.themXeTai();
                    System.out.println("Thêm thành công");
                    break;
                case "2":

                    quanLyChucNang.themXeOto();
                    System.out.println("Thêm thành công");
                    break;
                case "3":

                    quanLyChucNang.themXeMay();
                    System.out.println("Thêm thành công");
                    break;
                case "4":
                    return;
                case "5":
                    System.out.println("Tạm biệt");
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn từ 1-5");
            }
        } while (choice != "5");
    }
}
