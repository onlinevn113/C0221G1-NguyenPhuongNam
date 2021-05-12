package quan_ly_phuong_tien.controller;

import quan_ly_phuong_tien.HienThiPhuongTien;
import quan_ly_phuong_tien.ThemMoiPhuongTien;
import quan_ly_phuong_tien.common.DocGhiFile;
import quan_ly_phuong_tien.common.RegexAndException;
import quan_ly_phuong_tien.model.Oto;
import quan_ly_phuong_tien.model.PhuongTien;
import quan_ly_phuong_tien.model.XeMay;
import quan_ly_phuong_tien.model.XeTai;

import javax.imageio.stream.ImageInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyChucNang implements HienThiPhuongTien, ThemMoiPhuongTien {
    private String namSanXuatRegex = "^(\\d){4}$";

    public void xoaXeTai() {
        String regex = "^[\\d]{2}(C)[\\-][\\d]{3}(\\.)[\\d]{2}$";
        List<PhuongTien> xeTaiList=DocGhiFile.docFileXeTai();
        boolean kiemTra=false;
        while (true){
            hienThiXeTai();
            String bienKiemSoatXoa = RegexAndException.kiemTraNhapVaoTheoDinhDang("biển kiểm soát cần xoá", regex, "Vui lòng nhập biển kiểm soát", "XXC-XXX.XX (X : 0÷9)");
            for (int i = 0; i <xeTaiList.size() ; i++) {
                String bienKiemSoat=xeTaiList.get(i).getBienKiemSoat();
                if (bienKiemSoatXoa.equals(bienKiemSoat)){
                    kiemTra=true;
                    String xacNhan;
                    String regexXacNhan="^[\\d$]{1}";
                   while (true){
                       xacNhan=RegexAndException.kiemTraNhapVao("Bạn có chắc chắn muốn xoá\n" +
                               "1.Có\n" +
                               "2.Không",regexXacNhan,"Vui lòng nhập số ");
                       boolean kiemtra2=false;
                       switch (xacNhan){
                           case "1":
                               xeTaiList.remove(xeTaiList.get(i));
                               DocGhiFile.writeFile("xetai.csv", xeTaiList,false);
                               System.out.println("Xoá thành công");
                               kiemtra2=true;
                               break;
                           case "2":
                               System.out.println("Bạn không muốn xoá");
                               kiemtra2=true;
                               break;
                           default:
                               System.out.println("Vui lòng chọn 1 hoặc 2");
                               break;
                       }
                       if (kiemtra2){
                           break;
                       }
                   }
                }
            }
            if (kiemTra){
                break;
            }else {
                System.out.println("Vui lòng chọn theo danh sách");
            }

        }
    }
    public void xoaOto() {
        String regex = "[\\d]{2}([A]*[B]*)+[\\-][\\d]{3}[\\.][\\d]{2}";
        List<PhuongTien> phuongTienList=DocGhiFile.docFileOto();
        boolean kiemTra=false;
        while (true){
            hienThiXeOto();
            String bienKiemSoatXoa = RegexAndException.kiemTraNhapVaoTheoDinhDang("biển kiểm soát cần xoá", regex, "Vui lòng nhập biển kiểm soát", "XXC-XXX.XX (X : 0÷9)");
            for (int i = 0; i <phuongTienList.size() ; i++) {
                String bienKiemSoat=phuongTienList.get(i).getBienKiemSoat();
                System.out.println("Bạn có muốn xoá");
                String chon=new Scanner(System.in).nextLine();
                if (bienKiemSoatXoa.contains(bienKiemSoat)){
                    phuongTienList.remove(phuongTienList.get(i));
                    DocGhiFile.writeFile("oto.csv", phuongTienList,false);
                    kiemTra=true;
                    break;
                }
            }
            if (kiemTra){
                break;
            }else {
                System.out.println("Vui lòng chọn theo danh sách");
            }
        }

    }
    public void xoaXemay() {
        String regex="(\\d){2}(\\-)(A-Z){1}(\\d){1}(\\-)(\\d){3}(\\.)(\\d){2}";
        List<PhuongTien> phuongTienList=DocGhiFile.docFileXeMay();
        boolean kiemTra=false;
        while (true){
            hienThiXeMay();
            String bienKiemSoatXoa = RegexAndException.kiemTraNhapVaoTheoDinhDang("biển kiểm soát cần xoá", regex, "Vui lòng nhập biển kiểm soát", "XXC-XXX.XX (X : 0÷9)");
            ;
            for (int i = 0; i <phuongTienList.size() ; i++) {
                String bienKiemSoat=phuongTienList.get(i).getBienKiemSoat();
                if (bienKiemSoatXoa.contains(bienKiemSoat)){
                    phuongTienList.remove(phuongTienList.get(i));
                    DocGhiFile.writeFile("xemay.csv", phuongTienList,false);
                    kiemTra=true;
                    break;
                }
            }
            if (kiemTra){
                break;
            }else {
                System.out.println("Vui lòng chọn theo danh sách");
            }
        }

    }
    @Override
    public void hienThiXeTai() {
        List<PhuongTien> xetailist = DocGhiFile.docFileXeTai();
        for (PhuongTien xeTai:xetailist){
            xeTai.showInfo();
        }
    }

    @Override
    public void hienThiXeOto() {
        List<PhuongTien> otolist = DocGhiFile.docFileOto();
        for (PhuongTien oto : otolist) {
            oto.showInfo();
        }
    }

    @Override
    public void hienThiXeMay() {
        List<PhuongTien> xemaylist = DocGhiFile.docFileXeMay();
        for (PhuongTien xemay : xemaylist) {
            xemay.showInfo();
        }
    }

    @Override
    public void hienThiTatCa() {
        System.out.println("Danh sách xe tảin");
        hienThiXeTai();
        System.out.println("\nDanh sách xe oto");
        hienThiXeOto();
        System.out.println("\nDanh sách xe máy");
        hienThiXeMay();
    }


    @Override
    public void themXeTai() {
        String trongTaiRegex = "^(\\d){3}$";
        String xeTaiBienKiemSoatRegex = "^[\\d]{2}(C)[\\-][\\d]{3}(\\.)[\\d]{2}$";
        String bienKiemSoat = RegexAndException.kiemTraNhapVaoTheoDinhDang("biển kiểm soát", xeTaiBienKiemSoatRegex, "Vui lòng nhập biển kiểm soát", "XXC-XXX.XX (X : 0÷9)");
        String tenHangSanXuat = QuanLyNhapDuLieu.nhapHangSanXuat("hangsanxuat.csv");
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
        String tenHangSanXuat = QuanLyNhapDuLieu.nhapHangSanXuat("hangsanxuat.csv");
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
        String xeMayBienKiemSoatRegex="^[\\d]{2}[\\-][A-Z]{1}[\\d]{1}[\\-][\\d]{3}.[\\d]{2}$";
        String regexCongSuat = "(\\d)+";
        String bienKiemSoat =RegexAndException.kiemTraNhapVaoTheoDinhDang("biển kiểm soát", xeMayBienKiemSoatRegex, "Vui lòng nhập biển kiểm soát", "XXC-XXX.XX (X : 0÷9)");
        String tenHangSanXuat = QuanLyNhapDuLieu.nhapHangSanXuat("hangsanxuat.csv");
        String namSanXuat = RegexAndException.kiemTraNhapVaoTheoDinhDang("năm sản xuất", namSanXuatRegex, "Vui lòng nhập năm năm sản xuất", "4 Số");
        String chuSoHuu = RegexAndException.kiemTraNhapVaoTheoDinhDang("chủ sở hữu", RegexAndException.RegexVietNameseName, "Vui lòng nhập tên chủ sở hữu", "Họ Tên");
        String congSuat = RegexAndException.kiemTraNhapVaoTheoDinhDang("công suất", regexCongSuat, "Vui lòng nhập công xuất", "Số");


        List<PhuongTien> xemayList = new ArrayList<>();
        XeMay xeMay = new XeMay(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu, congSuat);
        xemayList.add(xeMay);
        DocGhiFile.writeFile("xemay.csv", xemayList, true);

    }
}
