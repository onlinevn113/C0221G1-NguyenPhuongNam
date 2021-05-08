package quan_ly_phuong_tien.model;

import quan_ly_phuong_tien.common.RegexAndException;

public class XeMay extends PhuongTien {
    private String CongSuat;

    public XeMay() {
    }


    public XeMay(String congSuat) {
        CongSuat = congSuat;
    }

    public XeMay(String bienKiemSoat, String tenHangSanXuat, String namSanXuat, String chuSoHuu, String congSuat) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        CongSuat = congSuat;
    }

    public String getCongSuat() {
        return CongSuat;
    }

    public void setCongSuat(String congSuat) {
        CongSuat = congSuat;
    }

    @Override
    public String toString() {
        return super.toString() +","+ CongSuat;
    }

    @Override
    public void showInfo() {
        System.out.println("XeMay{" +
                "CongSuat='" + CongSuat + '\'' +
                ", bienKiemSoat='" + bienKiemSoat + '\'' +
                ", tenHangSanXuat='" + tenHangSanXuat + '\'' +
                ", namSanXuat='" + namSanXuat + '\'' +
                ", chuSoHuu='" + chuSoHuu + '\'' +
                '}');
    }
}
