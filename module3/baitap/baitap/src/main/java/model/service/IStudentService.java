package model.service;

import model.bean.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    List<Student> findByAll();
    List<Student> findByName(String name);
    Student findById(int id);
    Map<String, String> create(Student student);
    Map<String,String> edit(Student student);
    boolean delete(int id);
}
