package model.service.impl;

import model.bean.DanhMuc;
import model.bean.SanPham;
import model.repository.SanPhamRepository;
import model.service.ISanPhamService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SanPhamImpl implements ISanPhamService {
    SanPhamRepository sanPhamRepository=new SanPhamRepository();
    @Override
    public List<SanPham> findByAll() {
        return sanPhamRepository.findByAll();
    }

    @Override
    public List<SanPham> findByName(String ten) {
        return sanPhamRepository.findByName(ten);
    }

    @Override
    public SanPham findById(int id) {
        return sanPhamRepository.findById(id);
    }

    @Override
    public boolean create(SanPham sanPham) {
        return  sanPhamRepository.create(sanPham);
    }

    @Override
    public boolean edit(SanPham sanPham) {
        return sanPhamRepository.edit(sanPham);
    }

    @Override
    public boolean delete(int id) {
        return sanPhamRepository.delete(id);
    }

    @Override
    public List<DanhMuc> findByAllDanhMuc() {
        return sanPhamRepository.findByAllDanhMuc();
    }
}
