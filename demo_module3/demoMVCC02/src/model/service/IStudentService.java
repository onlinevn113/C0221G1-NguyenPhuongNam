package model.service;

import model.bean.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findByAll();
    Student findById(String id);
    void update(String id, Student student);
    void add(Student student);
    void remove(String id);
}
