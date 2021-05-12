package quan_ly_phuong_tien.controller;

import quan_ly_phuong_tien.common.DocGhiFile;
import quan_ly_phuong_tien.common.RegexAndException;

import java.util.List;
import java.util.Scanner;

public class QuanLyNhapDuLieu {
    public static String nhapHangSanXuat(String filename) {
        String regex = "[\\d]+";
        Scanner scanner = new Scanner(System.in);
        boolean kiemTra = false;
        String chon;
        String hang = null;
        while (true) {
            List<String> stringList = DocGhiFile.docFileTheoDong(filename);
            System.out.println("Chọn hãng sản xuất");
            for (int i = 0; i < stringList.size(); i++) {
                System.out.println((i + 1) + " : " + stringList.get(i));
            }
            do {
                chon = RegexAndException.kiemTraNhapVao("số", regex, "Vui lòng nhập số");
                break;
            } while (true);
            for (int i = 0; i < stringList.size(); i++) {
                if (i == Integer.parseInt(chon) - 1) {
                    hang = stringList.get(i).split(",")[1];
                    kiemTra = true;
                    break;
                }
            }
            if (kiemTra) {
                break;
            } else {
                System.err.println("Vui lòng chọn theo danh sách!");
            }
        }
        return hang;
    }


    public static String nhapBienKiemSoatOto() {
        Scanner scanner = new Scanner(System.in);
        String regexXeDulich = "[\\d]{2}[A]+[\\-][\\d]{3}[\\.][\\d]{2}";
        String regexXeKhach = "[\\d]{2}[B]+[\\-][\\d]{3}[\\.][\\d]{2}";
        boolean kiemTra = false;
        String chon;
        String bienSo = "";
        while (true) {
            System.out.println("Chọn kiểu xe\n" +
                    "1.Xe du lịch\n" +
                    "2.Xe khách");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    System.out.println("Vui lòng nhập biển kiểm xoát");
                    bienSo = RegexAndException.kiemTraNhapVaoTheoDinhDang("biển số", regexXeDulich, "Vui lòng nhập biển số", "XXY-XXX.XX (X : 0÷9 , Y=A)");
                    kiemTra = true;
                    break;
                case "2":
                    bienSo = RegexAndException.kiemTraNhapVaoTheoDinhDang("biển số", regexXeKhach, "Vui lòng nhập biển số", "XXY-XXX.XX (X : 0÷9 , Y=B)");
                    kiemTra = true;
                    break;
                default:
                    System.out.println("Vui lòng chọn 1 hoặc 2");
            }
            if (kiemTra) {
                break;
            }
        }
        return bienSo;
    }

    public static String nhapSoChoNgoiOto() {
        Scanner scanner = new Scanner(System.in);
        boolean kiemTra = false;
        String chon;
        String soChoNgoi = "";
        while (true) {
            System.out.println("Chọn kiểu xe\n" +
                    "1. Xe 4 chỗ\n" +
                    "2. Xe 7 chỗ\n" +
                    "3. Xe 16 chỗ\n" +
                    "4. xe 45 chỗ\n");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    soChoNgoi = "4";
                    kiemTra = true;
                    break;
                case "2":
                    soChoNgoi = "7";
                    kiemTra = true;
                    break;
                case "3":
                    soChoNgoi = "16";
                    kiemTra = true;
                    break;
                case "4":
                    soChoNgoi = "45";
                    kiemTra = true;
                    break;
                default:
                    System.out.println("Vui lòng chọn số chỗ ngồi ");
            }
            if (kiemTra) {
                break;
            }
        }
        return soChoNgoi;
    }
}
