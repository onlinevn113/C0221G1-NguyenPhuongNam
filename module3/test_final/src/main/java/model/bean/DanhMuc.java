package model.bean;

public class DanhMuc {
    private int danhMuc;
    private String tenDanhMuc;

    public DanhMuc(int danhMuc, String tenDanhMuc) {
        this.danhMuc = danhMuc;
        this.tenDanhMuc = tenDanhMuc;
    }

    public int getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(int danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }
}
