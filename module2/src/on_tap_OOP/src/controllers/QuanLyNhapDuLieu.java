package controllers;

import commons.CanBoException;
import commons.DocGhiFile;
import models.CanBo;

import java.util.List;
import java.util.Scanner;

public class QuanLyNhapDuLieu {
    public static Scanner scanner = new Scanner(System.in);

    public static String kiemTraNgoaiLeNhapVao(String property, String regex, Exception exception) {
        property.trim();
        String nhapThuocTinh;
        do {
            try {
                System.out.println("Nhập: " + property);
                nhapThuocTinh = new Scanner(System.in).nextLine();
                if (!nhapThuocTinh.matches(regex)) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.err.println(exception.getMessage());
                System.err.println("Lỗi định dạng: " + regex + "\nThử lại: ");
            }
        } while (true);
        return nhapThuocTinh;
    }

    public static String nhapId() {
        String id = "CB-00";
        List<CanBo> canBoList = DocGhiFile.docFile("canbo.csv");
        if (canBoList.isEmpty()) {
            id += 1;
        } else {
            id += (canBoList.size() + 1);
        }
        return id;
    }








    public static String nhapHoTen() {
       return CanBoException.kiemTraNhapVaoMessage
               ("Họ tên",CanBoException.tenTiengViet,"bạn đã nhập sai tên vui lòng nhập lại");

    }
















    public static String nhapNamSinh() {
        return kiemTraNgoaiLeNhapVao("năm sinh", CanBoException.namSinh, new CanBoException());
    }



    public static String nhapGioiTinh() {
        boolean kiemTra = false;
        String chon = null;
        String gioiTinh = null;
        while (true) {
            System.out.println("Chon gioi tinh\n" +
                    "1.nam\n" +
                    "2.nu");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    gioiTinh = "Nam";
                    kiemTra = true;
                    break;
                case "2":
                    gioiTinh = "Nu";
                    kiemTra = true;
                    break;
                default:
                    System.out.println("vui long chon 1 hoac 2");
            }
            if (kiemTra) {
                break;
            }
        }
        return gioiTinh;
    }
    public static String nhapDiaChi() {
        return kiemTraNgoaiLeNhapVao("địa chỉ", CanBoException.diaChi, new CanBoException());
    }

    public static String nhapCapBac(){
      return kiemTraNgoaiLeNhapVao("cấp bậc" +
              "\nTheo đinhk dạng: (1-7)/7",CanBoException.kiemTraCapBac,new CanBoException());
    }



    public static String nhapNganhDaoTao(){
        boolean kiemTra = false;
        String chon  = null;
        String nganh = null;
        while (true){
            List<String> stringList = DocGhiFile.docFileNganhDaoTao("nganhDaoTao.csv");
            for (int i = 0;i <stringList.size();i++){
                System.out.println((i+1)+" : "+stringList.get(i));
            }
            System.out.println("chon theo danh sach");
            chon = scanner.nextLine();
            for (int i =0 ;i < stringList.size();i++){
                if (i ==  Integer.parseInt(chon)-1){
                    nganh = stringList.get(i).split(",")[1];
                    kiemTra= true;
                    break;
                }
            }
            if (kiemTra){
                break;
            }else {
                System.out.println("vui long chon theo danh sach");
            }
        }
        return nganh;
    }
    public static String nhapCongViec(){
        String congViec = null;
        boolean kiemTra = false;
        String chon = null;
        while (true){
            System.out.println("Chon cong viec\n" +
                    "1.PV-Ngoài trời\n" +
                    "2.PV-Trong nhà");
            chon = scanner.nextLine();
            switch (chon){
                case "1":
                    congViec = "PV-Ngoài trời";
                    kiemTra = true;
                    break;
                case "2":
                    congViec = "PV-Trong nhà";
                    kiemTra = true;
                    break;
                default:
                    System.out.println("vui long chon 1 hoac 2");
            }
            if (kiemTra){
                break;
            }
        }
        return congViec;
    }

}
