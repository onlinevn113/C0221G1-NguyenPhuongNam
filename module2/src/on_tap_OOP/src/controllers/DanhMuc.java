package controllers;

import java.util.Scanner;

public class DanhMuc {
    static Scanner scanner = new Scanner(System.in);
    public static void danhMuc(){
        String chon;
        while (true){
            System.out.println("Danh Muc:\n" +
                    "1 Nhập thông tin mới cho cán bộ\n" +
                    "2 Tìm kiếm theo tên(tương đối)\n" +
                    "3 Sắp xếp theo tên.\n" +
                    "4 Xóa theo danh sách \n" +
                    "5 Hiển thị thông tin về danh sách các cán bộ\n" +
                    "6 Thoát khỏi chương trình.\n");
            chon = scanner.nextLine();
            switch (chon){
                case "1":
                    QuanLyChucNang.themThongTinCanBo();
                    break;
                case "2":
                    QuanLyChucNang.timKiemTheoTen();
                    break;
                case "3":
                    QuanLyChucNang.sapXepTheoNamSinh();
                    break;
                case "4":
                    QuanLyChucNang.xoaTheoDanhSach();
                    break;
                case "5":
                    QuanLyChucNang.hienThiCanBo();
                    break;
                case "6":
                    System.exit(0);
                default:
                    System.out.println("vui long nhap theo danh muc , chon tu 1-6");
            }
        }
    }
}
