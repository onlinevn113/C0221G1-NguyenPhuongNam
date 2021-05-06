package models;

public class NhanVien extends  CanBo {
    private String congViec;

    public NhanVien() {
    }

    public NhanVien(String congViec) {
        this.congViec = congViec;
    }

    public NhanVien(String id, String hoTen, String namSinh, String gioiTinh, String diaChi, String congViec) {
        super(id, hoTen, namSinh, gioiTinh, diaChi);
        this.congViec = congViec;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    @Override
    public void showInfo() {
        System.out.println("NhanVien{" +
                "congViec='" + congViec + '\'' +
                ", id='" + id + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}');
    }

    @Override
    public String toString() {
        return super.toString()+", "+congViec;
    }
}
