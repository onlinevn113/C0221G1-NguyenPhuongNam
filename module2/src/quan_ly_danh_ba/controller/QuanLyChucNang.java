package quan_ly_danh_ba.controller;

import quan_ly_danh_ba.commons.DocGhiFile;
import quan_ly_danh_ba.commons.Validate;
import quan_ly_danh_ba.model.DanhBa;
import quan_ly_phuong_tien.common.RegexAndException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyChucNang {
    public static final String filename="contacts.csv";
    public static void themMoi() {
        String soDienThoai = QuanLyNhapLieu.kiemTraNhapVao("Số điẹn thoại", Validate.RegexSoDienThoai);
        String nhom = QuanLyNhapLieu.kiemTraNhapVao("nhóm", Validate.RegexNhom);
        String hoTen = QuanLyNhapLieu.kiemTraNhapVao("họ tên", Validate.RegexHoTen);
        String gioiTinh = QuanLyNhapLieu.nhapGioiTinh();
        String diaChi = QuanLyNhapLieu.kiemTraNhapVao("địa chỉ", Validate.RegexDiaChi);
        String ngaySinh = QuanLyNhapLieu.kiemTraNhapVao("ngày sinh", Validate.RegexNgayThangNamSinh);
        String email = QuanLyNhapLieu.kiemTraNhapVao("Email", Validate.RegexEmail);
        System.out.println("Thêm mới thành công!");
        List<DanhBa> danhBaList = new ArrayList<>();
        DanhBa danhBa = new DanhBa(soDienThoai, nhom, hoTen, gioiTinh, diaChi, ngaySinh, email);
        danhBaList.add(danhBa);
        DocGhiFile.writeFile(filename, danhBaList, true);
    }

    public static void capNhat() {
        System.out.println("Danh sách danh bạ!");
        List<DanhBa> danhSachDanhBa = DocGhiFile.docFile(filename);
        for (DanhBa danhBa : danhSachDanhBa) {
            danhBa.showInfo();
        }
        boolean co = false;
        List<DanhBa> danhBaList = DocGhiFile.docFile(filename);
        while (true) {
            String soDienThoaiCanSua = QuanLyNhapLieu.kiemTraNhapVao("số điẹn thoại cần sửa", Validate.RegexSoDienThoai);
            for (DanhBa danhBa : danhBaList) {
                if (danhBa.getSoDienThoai().equals(soDienThoaiCanSua)) {
                    co = true;
                    String nhom = QuanLyNhapLieu.kiemTraNhapVao("nhóm cần sửa", Validate.RegexNhom);
                    String hoTen = QuanLyNhapLieu.kiemTraNhapVao("họ tên cần sửa", Validate.RegexHoTen);
                    String gioiTinh = QuanLyNhapLieu.nhapGioiTinh();
                    String diaChi = QuanLyNhapLieu.kiemTraNhapVao("địa chỉ cần sửa", Validate.RegexDiaChi);
                    String ngaySinh = QuanLyNhapLieu.kiemTraNhapVao("ngày sinh cần sửa", Validate.RegexNgayThangNamSinh);
                    String email = QuanLyNhapLieu.kiemTraNhapVao("Email cần sửa", Validate.RegexEmail);
                    danhBa.setNhomDanhBa(nhom);
                    danhBa.setHoTen(hoTen);
                    danhBa.setGioiTinh(gioiTinh);
                    danhBa.setDiaChi(diaChi);
                    danhBa.setNgaySinh(ngaySinh);
                    danhBa.setEmail(email);
                    List<DanhBa> danhBaList2 = new ArrayList<>();
                    DanhBa danhBa2 = new DanhBa(soDienThoaiCanSua, nhom, hoTen, gioiTinh, diaChi, ngaySinh, email);
                    danhBaList2.add(danhBa2);
                    DocGhiFile.writeFile(filename, danhBaList2, true);
                    System.out.println("Số điện thoại "+soDienThoaiCanSua+" đã được thay đổi!");
                    break;
                }
            }
            if (co) {
                break;
            } else {
                System.out.println("không tìm thấy số điện thoại vui lòng nhập lại");
            }
        }
    }

    public static void xoa() {
        System.out.println("Danh sách danh bạ!");
        List<DanhBa> danhSachDanhBa = DocGhiFile.docFile(filename);
        for (DanhBa danhBa : danhSachDanhBa) {
            danhBa.showInfo();
        }
        List<DanhBa> danhBaList = DocGhiFile.docFile(filename);
        boolean kiemTra = false;
        while (true) {
            String soDienThoaiCanXoa = QuanLyNhapLieu.kiemTraNhapVao("Số điẹn thoại cần xoá", Validate.RegexSoDienThoai);
            for (int i = 0; i < danhBaList.size(); i++) {
                String soDienThoai = danhBaList.get(i).getSoDienThoai();
                if (soDienThoaiCanXoa.equals(soDienThoai)) {
                    kiemTra = true;
                    String xacNhan;
                    String regexXacNhan = "^[\\d$]{1}";
                    while (true) {
                        xacNhan = RegexAndException.kiemTraNhapVao("Bạn có chắc chắn muốn xoá\n" +
                                "1.Có\n" +
                                "2.Không", regexXacNhan, "Vui lòng nhập số ");
                        boolean kiemtra2 = false;
                        switch (xacNhan) {
                            case "1":
                                danhBaList.remove(danhBaList.get(i));
                                DocGhiFile.writeFile(filename, danhBaList, false);
                                System.out.println("Xoá thành công");
                                kiemtra2 = true;
                                break;
                            case "2":
                                System.out.println("Bạn không muốn xoá");
                                kiemtra2 = true;
                                break;
                            default:
                                System.out.println("Vui lòng chọn 1 hoặc 2");
                                break;
                        }
                        if (kiemtra2) {
                            break;
                        }
                    }
                }
            }
            if (kiemTra) {
                break;
            } else {
                System.out.println("Vui lòng chọn theo danh sách");
            }

        }
    }


    public static void xemDanhSach() {
        List<DanhBa> danhBaList = DocGhiFile.docFile(filename);
        for (DanhBa danhBa : danhBaList) {
            danhBa.showInfo();
        }
    }

    public static void timKiem() {
        List<DanhBa> danhBaList = DocGhiFile.docFile(filename);
        System.out.println("Nhập số điện thoại hoặc họ tên cần tìm");
        String danhBaCanTim = new Scanner(System.in).nextLine();
        for (int i = 0; i < danhBaList.size(); i++) {
            if (danhBaList.get(i).getSoDienThoai().contains(danhBaCanTim) || danhBaList.get(i).getHoTen().contains(danhBaCanTim)) {
                danhBaList.get(i).showInfo();
            }
        }
    }
}
