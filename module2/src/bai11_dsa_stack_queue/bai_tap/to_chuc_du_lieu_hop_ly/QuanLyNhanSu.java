package bai11_dsa_stack_queue.bai_tap.to_chuc_du_lieu_hop_ly;

public class QuanLyNhanSu {
    public String hoTen;
    public String gioiTinh;
    public String ngayThangNamSInh;

    public QuanLyNhanSu(String hoTen, String gioiTinh, String ngayThangNamSInh) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngayThangNamSInh = ngayThangNamSInh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getNgayThangNamSInh() {
        return ngayThangNamSInh;
    }

    @Override
    public String toString() {
        return "QuanLyNhanSu{" +
                "hoTen='" + hoTen + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", date=" + ngayThangNamSInh +
                '}';
    }
}
