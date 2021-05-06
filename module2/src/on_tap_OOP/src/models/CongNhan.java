package models;

public class CongNhan extends CanBo {
    private String bac;

    public CongNhan() {
    }



    public CongNhan(String bac) {
        this.bac = bac;
    }

    public CongNhan(String id, String hoTen, String namSinh, String gioiTinh, String diaChi, String bac) {
        super(id, hoTen, namSinh, gioiTinh, diaChi);
        this.bac = bac;
    }

    public String getBac() {
        return bac;
    }

    public void setBac(String bac) {
        this.bac = bac;
    }

    @Override
    public void showInfo() {
        System.out.println("CongNhan{" +
                "bac='" + bac + '\'' +
                ", id='" + id + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}');
    }

    @Override
    public String toString() {
        return super.toString()+", "+bac;
    }
}
