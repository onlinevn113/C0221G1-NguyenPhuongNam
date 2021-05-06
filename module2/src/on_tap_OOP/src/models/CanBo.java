package models;

public abstract class CanBo {
    //id(Tự tăng CB-001) , Họ tên, năm sinh, giới tính, địa chỉ
    protected String id;
    protected String hoTen;
    protected String namSinh;
    protected String gioiTinh;
    protected String diaChi;

    public CanBo() {
    }

    public CanBo(String id, String hoTen, String namSinh, String gioiTinh, String diaChi) {
        this.id = id;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public abstract void showInfo();

    @Override
    public String toString() {
        return id +
                ", '" + hoTen +
                ", " + namSinh +
                ", " + gioiTinh +
                ", " + diaChi
                ;
    }
}
