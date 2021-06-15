package model.repository;

import model.bean.DanhMuc;
import model.bean.SanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {
    BaseRepository baseRepository = new BaseRepository();

    public List<SanPham> findByAll() {
        Connection connection = baseRepository.connectDataBase();
        List<SanPham> sanPhams = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from san_pham");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_san_pham");
                String ten = resultSet.getString("ten");
                int gia = resultSet.getInt("gia");
                int soLuong = resultSet.getInt("so_luong");
                String mauSac = resultSet.getString("mau_sac");
                String moTa = resultSet.getString("mo_ta");
                int danhMuc = resultSet.getInt("id_danh_muc");
                sanPhams.add(new SanPham(id, ten, gia, soLuong, mauSac, moTa, danhMuc));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPhams;
    }


    public List<SanPham> findByName(String name1) {
        Connection connection = baseRepository.connectDataBase();
        List<SanPham> sanPhams = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from san_pham where ten like ?;");
            statement.setString(1, "%" + name1 + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_san_pham");
                String ten = resultSet.getString("ten");
                int gia = resultSet.getInt("gia");
                int soLuong = resultSet.getInt("so_luong");
                String mauSac = resultSet.getString("mau_sac");
                String moTa = resultSet.getString("mo_ta");
                int danhMuc = resultSet.getInt("id_danh_muc");
                sanPhams.add(new SanPham(id, ten, gia, soLuong, mauSac, moTa, danhMuc));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPhams;
    }
    public static void main(String[] args) {
        System.out.println(new SanPhamRepository().findByName("namnam").size());
    }

    public SanPham findById(int id1) {
        Connection connection = baseRepository.connectDataBase();
        SanPham sanPham = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from san_pham where id_san_pham=?");
            statement.setInt(1, id1);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_san_pham");
                String ten = resultSet.getString("ten");
                int gia = resultSet.getInt("gia");
                int soLuong = resultSet.getInt("so_luong");
                String mauSac = resultSet.getString("mau_sac");
                String moTa = resultSet.getString("mo_ta");
                int danhMuc = resultSet.getInt("id_danh_muc");
                sanPham = new SanPham(id, ten, gia, soLuong, mauSac, moTa, danhMuc);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPham;
    }


    public boolean create(SanPham sanPham) {
        Connection connection = baseRepository.connectDataBase();
        boolean check = false;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `school`.`san_pham` (ten, gia,so_luong,mau_sac ,mo_ta , id_danh_muc)\n" +
                    "VALUES ( ?, ?, ?, ?, ?, ?);");
            statement.setString(1, sanPham.getTen());
            statement.setInt(2, sanPham.getGia());
            statement.setInt(3, sanPham.getSoLuong());
            statement.setString(4, sanPham.getMauSac());
            statement.setString(5, sanPham.getMoTa());
            statement.setInt(6, sanPham.getDanhMuc());
            check = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean edit(SanPham sanPham) {
        Connection connection = baseRepository.connectDataBase();
        boolean check = false;
        try {
            PreparedStatement statement = connection.prepareStatement("update `school`.`san_pham`\n" +
                    "set ten=?,gia=?,so_luong=?,mau_sac=?,mo_ta=?,id_danh_muc=? where id_san_pham =?;");
            statement.setString(1, sanPham.getTen());
            statement.setInt(2, sanPham.getGia());
            statement.setInt(3, sanPham.getSoLuong());
            statement.setString(4, sanPham.getMauSac());
            statement.setString(5, sanPham.getMoTa());
            statement.setInt(6, sanPham.getDanhMuc());
            statement.setInt(7, sanPham.getId());
            check = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }


    public boolean delete(int id) {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from san_pham where id_san_pham=?;");
            statement.setInt(1, id);
            check = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public List<DanhMuc> findByAllDanhMuc() {
        Connection connection = baseRepository.connectDataBase();
        List<DanhMuc> danhMucs = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from category");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idDanhMuc = resultSet.getInt("id_danh_muc");
                String danhMuc = resultSet.getString("danh_muc");
                danhMucs.add(new DanhMuc(idDanhMuc, danhMuc));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhMucs;
    }
}
