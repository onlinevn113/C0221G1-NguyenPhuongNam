package Final_test.controller;

import Final_test.commons.DocGhiFile;
import quan_ly_phuong_tien.common.RegexAndException;

import java.util.List;
import java.util.Scanner;

public class QuanLyNhapLieu {
    public static String nhapId(String filename) {
        String id = "";
        List<String> stringList = DocGhiFile.docFileTheoDong(filename);
        if (stringList.isEmpty()) {
            id += 1;
        } else {
            id += (stringList.size() + 1);
        }
        return id;
    }

    public static String nhapGioiTinh() {
        boolean kiemTra = false;
        String chon = null;
        String gioiTinh = null;
        while (true) {
            System.out.println("Chon gioi tinh\n" +
                    "1.Nam\n" +
                    "2.Nữ");
            chon = new Scanner(System.in).nextLine();
            switch (chon) {
                case "1":
                    gioiTinh = "Nam";
                    kiemTra = true;
                    break;
                case "2":
                    gioiTinh = "Nữ";
                    kiemTra = true;
                    break;
                default:
                    System.out.println("Vui lòng chọn 1 hoặc 2");
            }
            if (kiemTra) {
                break;
            }
        }
        return gioiTinh;
    }
    public static String nhapTheoFileCoSan(String filename) {
        String regex = "[\\d]+";
        boolean kiemTra = false;
        String chon;
        String duLieu = null;
        while (true) {
            List<String> stringList = DocGhiFile.docFileTheoDong(filename);
            for (int i = 0; i < stringList.size(); i++) {
                System.out.println((i + 1) + " : " + stringList.get(i));
            }
            do {
                chon = RegexAndException.kiemTraNhapVao("số", regex, "Vui lòng nhập số");
                break;
            } while (true);
            for (int i = 0; i < stringList.size(); i++) {
                if (i == Integer.parseInt(chon) - 1) {
                    duLieu = stringList.get(i).split(",")[1];
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
        return duLieu;
    }
}
