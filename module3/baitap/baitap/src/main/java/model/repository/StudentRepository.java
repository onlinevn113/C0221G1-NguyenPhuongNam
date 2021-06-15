package model.repository;

import model.bean.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentRepository {
    BaseRepository baseRepository = new BaseRepository();

    public List<Student> findByAll() {
        Connection connection = baseRepository.connectDataBase();
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from students");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("s_name");
                int gender = resultSet.getInt("gender");
                String birthday = resultSet.getString("birthday");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                students.add(new Student(id, name, gender, birthday, email, address));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }


    public List<Student> findByName(String name1) {
        Connection connection = baseRepository.connectDataBase();
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from students where s_name like ?");
            statement.setString(1, "%" + name1 + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("s_name");
                int gender = resultSet.getInt("gender");
                String birthday = resultSet.getString("birthday");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                students.add(new Student(id, name, gender, birthday, email, address));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }


    public Student findById(int id1) {
        Connection connection = baseRepository.connectDataBase();
        Student students = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from students where id=?");
            statement.setInt(1, id1);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("s_name");
                int gender = resultSet.getInt("gender");
                String birthday = resultSet.getString("birthday");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                students = new Student(id, name, gender, birthday, email, address);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {

    }
    public void create(Student student) {
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `school`.`students` ( s_name, gender, birthday, email, address)" +
                    "values(?,?,?,?,?)");
            statement.setString(1, student.getName());
            statement.setInt(2, student.getGender());
            statement.setString(3, student.getBirthday());
            statement.setString(4, student.getEmail());
            statement.setString(5, student.getAddress());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(Student student) {
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE `school`.`students` \n" +
                    "SET `s_name` = ?, `gender`=?,`birthday`=?, `email` = ?, `address` = ? WHERE (`id` = ?);");
            statement.setString(1, student.getName());
            statement.setInt(2, student.getGender());
            statement.setString(3, student.getBirthday());
            statement.setString(4, student.getEmail());
            statement.setString(5, student.getAddress());
            statement.setInt(6, student.getId());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean delete(int id) {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from students where id=?");
            statement.setInt(1, id);
            check = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }


}
