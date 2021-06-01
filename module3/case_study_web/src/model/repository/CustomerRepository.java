package model.repository;

import model.bean.Customer;

import java.sql.Connection;
import java.util.List;

public class CustomerRepository {
    BaseRepository baseRopository = new BaseRepository();
    final String SELECT_ALL_STUDENT ="select*from khach_hang;";

    final String SELECT_STUDENT_BY_ID="select*from khach_hang where id_khach_hang=?;";

    final String UPDATE_STUDENT_BY_ID ="update khach_hang \n" +
            "set id_loai_khach=?, ho_ten='?', ngay_sinh='?', so_cmnd=?, \n" +
            "so_dien_thoai=?,email='?',dia_chi='?'\n" +
            "where id_khach_hang=?;";
//    public List<Customer> findByAll(){
//        Connection connection=baseRopository.connectDataBase();
//    }
}
