package quan_ly_phuong_tien.model;

public class XeTai extends PhuongTien {
    private String trongTai;

    public XeTai() {
    }

    public XeTai(String bienKiemSoat, String tenHangSanXuat, String namSanXuat, String chuSoHuu) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
    }

    public XeTai(String bienKiemSoat, String tenHangSanXuat, String namSanXuat, String chuSoHuu, String trongTai) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public String getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(String trongTai) {
        this.trongTai = trongTai;
    }

//    @Override
//    public String toString() {
//        return super.toString() + "," + trongTai;
//    }

    @Override
    public String toString() {
        return "XeTai{" +
                "trongTai='" + trongTai + '\'' +
                ", bienKiemSoat='" + bienKiemSoat + '\'' +
                ", tenHangSanXuat='" + tenHangSanXuat + '\'' +
                ", namSanXuat='" + namSanXuat + '\'' +
                ", chuSoHuu='" + chuSoHuu + '\'' +
                '}';
    }

    public static void main(String[] args) {
        XeTai xeTai=new XeTai();
        xeTai.showInfo();
    }
    @Override
    public void showInfo() {
        System.out.printf("Xe tải:\n"+"Trọng tải=%d,biển kiểm soát=%d,tên hãng sản xuất=%đ,năm sản xuất=%đ, chủ sở hữu=%đ",trongTai,bienKiemSoat,tenHangSanXuat,namSanXuat,chuSoHuu);
    }
}
