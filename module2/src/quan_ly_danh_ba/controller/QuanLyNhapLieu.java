package quan_ly_danh_ba.controller;

import quan_ly_danh_ba.commons.DocGhiFile;
import quan_ly_danh_ba.commons.MessageException;
import quan_ly_phuong_tien.common.RegexAndException;

import java.time.Year;
import java.util.List;
import java.util.Scanner;

public class QuanLyNhapLieu {

    public static String nhapGioiTinh() {
        boolean kiemTra = false;
        String chon = null;
        String gioiTinh = null;
        while (true) {
            System.out.println("Chon gioi tinh\n" +
                    "1. Nam\n" +
                    "2. Nữ\n" +
                    "3. Khác");
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
                case "3":
                    gioiTinh = "Khác";
                    kiemTra = true;
                    break;
                default:
                    System.out.println("Vui lòng chọn theo danh sách");
            }
            if (kiemTra) {
                break;
            }
        }
        return gioiTinh;
    }


    public static String kiemTraNhapVao(String thuocTinh, String regex) {
        String nhap = null;
        while (true) {
            try {
                System.out.println("Nhập: " + thuocTinh);
                nhap = new Scanner(System.in).nextLine().trim();
                if (!nhap.matches(regex)) {
                    throw new Exception("");
                }
                return nhap;
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Bạn đã nhập sai. " + "\nVui lòng nhập lại: " + thuocTinh);
            }
        }
    }


















//    public static String kiemTraNhapVaoNgoaiLe(String property, String regex) {
//        String nhapThuocTinh;
//        do {
//            try {
//                System.out.println("Nhập: " + property);
//                nhapThuocTinh = new Scanner(System.in).nextLine().trim();
//                if (!nhapThuocTinh.matches(regex)) {
//                    throw new MessageException("Bạn đã nhập sai " + property);
//                }
//                break;
//            } catch (MessageException e) {
//                e.printStackTrace();
//                System.err.println("Vui lòng nhập lại: " + property);
//            }
//        } while (true);
//        return nhapThuocTinh;
//    }
//
//    public static String nhapTheoFileCoSan(String filename) {
//        String regex = "[\\d]+";
//        boolean kiemTra = false;
//        String chon;
//        String duLieu = null;
//        while (true) {
//            List<String> stringList = DocGhiFile.docFileTheoDong(filename);
//            for (int i = 0; i < stringList.size(); i++) {
//                System.out.println((i + 1) + " : " + stringList.get(i));
//            }
//            do {
//                chon = RegexAndException.kiemTraNhapVao("số", regex, "Vui lòng nhập số");
//                break;
//            } while (true);
//            for (int i = 0; i < stringList.size(); i++) {
//                if (i == Integer.parseInt(chon) - 1) {
//                    duLieu = stringList.get(i).split(",")[1];
//                    kiemTra = true;
//                    break;
//                }
//            }
//            if (kiemTra) {
//                break;
//            } else {
//                System.err.println("Vui lòng chọn theo danh sách!");
//            }
//        }
//        return duLieu;
//    }
//
//    public static String kiemTraNhapTren18() {
//        String kiemTraNgayNhap = "^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
//        String nhap = null;
//        do {
//            try {
//                System.out.println("Nhập ngày tháng năm sinh muốn kiểm tra");
//                nhap = new Scanner(System.in).nextLine().trim();
//                int namSinh = Integer.parseInt(nhap.split("/")[2]);
//                int namHienTai = Year.now().getValue();
//                if (!nhap.matches(kiemTraNgayNhap)) {
//                    throw new Exception();
//                } else if (namSinh <= 1900 || namHienTai - namSinh < 18 || namSinh - namHienTai > 1) {
//                    throw new Exception();
//                }
//                break;
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.err.println("Nhập sai thử lại: ");
//            }
//        } while (true);
//        return nhap;
//    }









//    public static String nhapId(String filename) {
//        String id = "";
//        List<String> stringList = DocGhiFile.docFileTheoDong(filename);
//        if (stringList.isEmpty()) {
//            id += 1;
//        } else {
//            id += (stringList.size() + 1);
//        }
//        return id;
//    }


//    public static String kiemTraNhapVaoTheoDinhDang(String thuocTinh, String regex, String tinNhan,String dinhDang) {
//        String nhap;
//        while (true) {
//            try {
//                System.out.println("Nhập " + thuocTinh);
//                nhap =new Scanner(System.in).nextLine().trim();
//                if (!nhap.matches(regex)) {
//                    throw new Exception();
//                }
//                return nhap;
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.err.println(tinNhan+"\nVui lòng nhập lại theo định dạng: "+dinhDang);
//            }
//        }
//    }

}
