package model.service;

import model.bean.DanhMuc;
import model.bean.SanPham;

import java.util.List;

public interface ISanPhamService {
    List<SanPham> findByAll();
    List<SanPham> findByName(String ten);
    SanPham findById(int id);
    boolean create(SanPham sanPham);
    boolean edit(SanPham sanPham);
    boolean delete(int id);
    List<DanhMuc> findByAllDanhMuc();
}
