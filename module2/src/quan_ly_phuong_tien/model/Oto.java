package quan_ly_phuong_tien.model;

public class Oto extends PhuongTien {
    private String soChoNgoi;
    private String kieuXe;

    public Oto() {
    }

    public Oto(String bienKiemSoat, String tenHangSanXuat, String namSanXuat, String chuSoHuu) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
    }

    public Oto(String bienKiemSoat, String tenHangSanXuat, String namSanXuat, String chuSoHuu, String soChoNgoi, String kieuXe) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public String getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(String soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }

    @Override
    public String toString() {
        return super.toString() +","+ soChoNgoi +","+ kieuXe;
    }
    

    @Override
    public void showInfo() {
        System.out.println("Oto{" +
                "soChoNgoi='" + soChoNgoi + '\'' +
                ", kieuXe='" + kieuXe + '\'' +
                ", bienKiemSoat='" + bienKiemSoat + '\'' +
                ", tenHangSanXuat='" + tenHangSanXuat + '\'' +
                ", namSanXuat='" + namSanXuat + '\'' +
                ", chuSoHuu='" + chuSoHuu + '\'' +
                '}');
    }
}
