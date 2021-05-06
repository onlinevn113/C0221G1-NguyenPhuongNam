package controllers;
import commons.DocGhiFile;
import models.CanBo;
import models.CongNhan;
import models.KySu;
import models.NhanVien;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class QuanLyChucNang {
    static Scanner scanner = new Scanner(System.in);
    public static void themThongTinCanBo(){
        String chon;
        while (true){
            System.out.println("Danh Muc:\n" +
                    "1 Them Cong Nhan\n" +
                    "2 Them Ky Su\n" +
                    "3 Them Nhan Vien\n" +
                    "4 Tro ve Danh Muc \n" +
                    "5 Thoát khỏi chương trình.\n");
            chon = scanner.nextLine();
            switch (chon){
                case "1":
                    themCongNhan();
                    break;
                case "2":
                    themKySu();
                    break;
                case "3":
                    themNhanVien();
                    break;
                case "4":
                    return;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("vui long nhap theo danh muc , chon tu 1-6");
            }
        }
    }
    public static void themCongNhan(){
        //ing id, String hoTen, String namSinh, String gioiTinh, String diaChi, String bac) {
        String id = QuanLyNhapDuLieu.nhapId();
        String hoTen = QuanLyNhapDuLieu.nhapHoTen();
        String namSinh = QuanLyNhapDuLieu.nhapNamSinh();
        String gioiTinh = QuanLyNhapDuLieu.nhapGioiTinh();
        String diaChi = QuanLyNhapDuLieu.nhapDiaChi();
        String bac = QuanLyNhapDuLieu.nhapCapBac();
        List<CanBo> canBoList = new ArrayList<>();
        CanBo congNhan = new CongNhan(id,hoTen,namSinh,gioiTinh,diaChi,bac);
        canBoList.add(congNhan);
        DocGhiFile.ghiFile("canbo.csv",canBoList,true);
    }
    public static void themKySu(){
        String id = QuanLyNhapDuLieu.nhapId();
        String hoTen = QuanLyNhapDuLieu.nhapHoTen();
        String namSinh = QuanLyNhapDuLieu.nhapNamSinh();
        String gioiTinh = QuanLyNhapDuLieu.nhapGioiTinh();
        String diaChi = QuanLyNhapDuLieu.nhapDiaChi();
        String nganh = QuanLyNhapDuLieu.nhapNganhDaoTao();

        List<CanBo> canBoList = new ArrayList<>();
        CanBo kySu = new KySu(id,hoTen,namSinh,gioiTinh,diaChi,nganh);
        canBoList.add(kySu);
        DocGhiFile.ghiFile("canbo.csv",canBoList,true);
    }
    public static void themNhanVien(){
        String id = QuanLyNhapDuLieu.nhapId();
        String hoTen = QuanLyNhapDuLieu.nhapHoTen();
        String namSinh = QuanLyNhapDuLieu.nhapNamSinh();
        String gioiTinh = QuanLyNhapDuLieu.nhapGioiTinh();
        String diaChi = QuanLyNhapDuLieu.nhapDiaChi();
        String congViec = QuanLyNhapDuLieu.nhapCongViec();

        List<CanBo> canBoList = new ArrayList<>();
        CanBo nhanVien = new NhanVien(id,hoTen,namSinh,gioiTinh,diaChi,congViec);
        canBoList.add(nhanVien);
        DocGhiFile.ghiFile("canbo.csv",canBoList,true);
    }

    public static void timKiemTheoTen(){
        String ten = null;
        List<CanBo> canBoList = DocGhiFile.docFile("canbo.csv");
        System.out.println("nhap vao ten can tim kiem");
        ten = scanner.nextLine();
        for (CanBo canBo : canBoList){
            if (canBo.getHoTen().contains(ten)){
                System.out.println(canBo);

            }
        }
    }

    public static void sapXepTheoNamSinh(){
        List<CanBo> canBoList = DocGhiFile.docFile("canbo.csv");
        canBoList.sort(Comparator.comparing(CanBo::getNamSinh));
        for (CanBo canBo : canBoList){
            canBo.showInfo();
        }
    }

    public static void xoaTheoDanhSach(){
        boolean kiemTra = false;
        String chon = null;
        List<CanBo> canBoList = DocGhiFile.docFile("canbo.csv");
        while (true){
            for (int i =0 ;i<canBoList.size();i++){
                System.out.println((i+1)+" : "+canBoList.get(i));
            }
            System.out.println("chon can bo can xoa");
            chon = scanner.nextLine();
            for (int i =0 ;i<canBoList.size();i++){
                if (i == Integer.parseInt(chon)-1){
                    canBoList.remove(i);
                    DocGhiFile.ghiFile("canbo.csv",canBoList,false);
                    kiemTra = true;
                    break;
                }
            }
            if (kiemTra){
                break;
            }else {
                System.out.println("vui long chon theo danh sach");
            }

        }
    }

    public static void hienThiCanBo(){
        String chon;
        while (true){
            System.out.println("Danh Muc:\n" +
                    "1 Hien Thi Cong Nhan\n" +
                    "2 Hien thi Ky Su\n" +
                    "3 Hien thi Nhan Vien\n" +
                    "4.Hien thi tat ca\n" +
                    "5.Tro ve Danh Muc \n" +
                    "6.Thoát khỏi chương trình.\n");
            chon = scanner.nextLine();
            switch (chon){
                case "1":
                    hienThiCongNhan();
                    break;
                case "2":
                    hienThiKySu();
                    break;
                case "3":
                    hienThiNhanVien();
                    break;
                case "4":
                    hienThiTatCa();
                    break;
                case "5":
                    return;
                case "6":
                    System.exit(0);
                default:
                    System.out.println("vui long nhap theo danh muc , chon tu 1-6");
            }
        }
    }
    public static void hienThiCongNhan(){
        List<CanBo> canBoList = DocGhiFile.docFile("canbo.csv");
        for (CanBo canBo : canBoList){
            if (canBo instanceof  CongNhan){
                canBo.showInfo();
            }
        }
    }
    public static void hienThiKySu(){
        List<CanBo> canBoList = DocGhiFile.docFile("canbo.csv");
        for (CanBo canBo : canBoList){
            if (canBo instanceof  KySu){
                canBo.showInfo();
            }
        }
    }
    public static void hienThiNhanVien(){
        List<CanBo> canBoList = DocGhiFile.docFile("canbo.csv");
        for (CanBo canBo : canBoList){
            if (canBo instanceof  NhanVien){
                canBo.showInfo();
            }
        }
    }
    public static void hienThiTatCa(){
        List<CanBo> canBoList = DocGhiFile.docFile("canbo.csv");
        for (CanBo canBo : canBoList){
            canBo.showInfo();
        }
    }





}
