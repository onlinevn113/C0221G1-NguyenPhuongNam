package quan_ly_phuong_tien.controller;

import quan_ly_phuong_tien.HienThiPhuongTien;
import quan_ly_phuong_tien.ThemMoiPhuongTien;
import quan_ly_phuong_tien.common.DocGhiFile;
import quan_ly_phuong_tien.common.RegexAndException;
import quan_ly_phuong_tien.model.Oto;
import quan_ly_phuong_tien.model.PhuongTien;
import quan_ly_phuong_tien.model.XeMay;
import quan_ly_phuong_tien.model.XeTai;

import java.util.ArrayList;
import java.util.List;

public class QuanLyChucNang implements HienThiPhuongTien, ThemMoiPhuongTien {

    private String xeOtoBienKiemSoatRegex = "";
    private String xeMayBienKiemSoatRegex = "";
    private String namSanXuatRegex = "^(\\d){4}$";
    private String trongTaiRegex = "^(\\d){3}$";

    public void xoaPhuongTien(String filename) {


    }

    public static void main(String[] args) {
        QuanLyChucNang quanLyChucNang = new QuanLyChucNang();
        quanLyChucNang.hienThiXeOto();
    }

    @Override
    public void hienThiXeTai() {
        List<XeTai> xetailist = DocGhiFile.docFileXeTai();
        for (XeTai xeTai:xetailist){
            xeTai.showInfo();
        }


    }

    @Override
    public void hienThiXeOto() {
        List<Oto> otolist = DocGhiFile.docFileOto();
        for (Oto oto : otolist) {
            oto.showInfo();
        }
    }

    @Override
    public void hienThiXeMay() {
        List<XeMay> xemaylist = DocGhiFile.docFileXeMay();
        for (XeMay xemay : xemaylist) {
            xemay.showInfo();
        }
    }

    @Override
    public void hienThiTatCa() {

    }


    //Biển kiểm soát , tên hãng sản xuất, năm sản xuất, chủ sở hữu.
    @Override
    public void themXeTai() {
        String xeTaiBienKiemSoatRegex = "^[\\d]{2}(C)[\\-][\\d]{3}(\\.)[\\d]{2}$";
        String bienKiemSoat = RegexAndException.kiemTraNhapVaoTheoDinhDang("biển kiểm soát", xeTaiBienKiemSoatRegex, "Vui lòng nhập biển kiểm soát", "XXC-XXX.XX (X : 0÷9)");
        String tenHangSanXuat = QuanLyNhapDuLieu.nhapTheoFileCoSan("hangsanxuat.csv");
        String namSanXuat = RegexAndException.kiemTraNhapVaoTheoDinhDang("năm sản xuất", namSanXuatRegex, "Vui lòng nhập năm năm sản xuất", "");
        String chuSoHuu = RegexAndException.kiemTraNhapVaoTheoDinhDang("chủ sở hữu", RegexAndException.RegexVietNameseName, "Vui lòng nhập tên chủ sở hữu", "Họ Tên");


        String trongTai = RegexAndException.kiemTraNhapVaoTheoDinhDang("trong tải", trongTaiRegex, "Vui lòng nhập trọng tải", "XXX (X: 0-9KG)");


        List<PhuongTien> xeTailist = new ArrayList<>();
        XeTai xeTai = new XeTai(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu, trongTai);
        xeTailist.add(xeTai);
        DocGhiFile.writeFile("xetai.csv", xeTailist, true);
    }

    @Override
    public void themXeOto() {
        String bienKiemSoat = QuanLyNhapDuLieu.nhapBienKiemSoatOto();
        String tenHangSanXuat = QuanLyNhapDuLieu.nhapTheoFileCoSan("hangsanxuat.csv");
        String namSanXuat = RegexAndException.kiemTraNhapVaoTheoDinhDang("năm sản xuất", namSanXuatRegex, "Vui lòng nhập năm năm sản xuất", "");
        String chuSoHuu = RegexAndException.kiemTraNhapVaoTheoDinhDang("chủ sở hữu", RegexAndException.RegexVietNameseName, "Vui lòng nhập tên chủ sở hữu", "Họ Tên");

        String soChoNgoi = QuanLyNhapDuLieu.nhapSoChoNgoiOto();
        String kieuXe = RegexAndException.kiemTraNhapVaoTheoDinhDang("kieu xe", RegexAndException.RegexAlphaber, "Vui lòng nhập kiểu xe", "chữ cái không dấu");

        List<PhuongTien> otoList = new ArrayList<>();
        Oto oto = new Oto(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu, soChoNgoi, kieuXe);
        otoList.add(oto);
        DocGhiFile.writeFile("oto.csv", otoList, true);
    }

    @Override
    public void themXeMay() {
        String regexCongSuat = "(\\d)+";
        String bienKiemSoat = QuanLyNhapDuLieu.nhapBienKiemSoatOto();
        String tenHangSanXuat = QuanLyNhapDuLieu.nhapTheoFileCoSan("hangsanxuat.csv");
        String namSanXuat = RegexAndException.kiemTraNhapVaoTheoDinhDang("năm sản xuất", namSanXuatRegex, "Vui lòng nhập năm năm sản xuất", "4 Số");
        String chuSoHuu = RegexAndException.kiemTraNhapVaoTheoDinhDang("chủ sở hữu", RegexAndException.RegexVietNameseName, "Vui lòng nhập tên chủ sở hữu", "Họ Tên");
        String congSuat = RegexAndException.kiemTraNhapVaoTheoDinhDang("chủ sở hữu", regexCongSuat, "Vui lòng nhập công xuất", "Số");


        List<PhuongTien> xemayList = new ArrayList<>();
        XeMay xeMay = new XeMay(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu, "");
        xemayList.add(xeMay);
        DocGhiFile.writeFile("oto.csv", xemayList, true);

    }
}
