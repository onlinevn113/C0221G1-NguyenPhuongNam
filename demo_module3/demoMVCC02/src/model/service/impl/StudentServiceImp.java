package model.service.impl;

import model.bean.Student;
import model.repository.StudentRepository;
import model.service.IStudentService;

import java.util.List;

public class StudentServiceImp implements IStudentService {
    StudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findByAll() {
        return studentRepository.findByAll();
    }

    @Override
    public Student findById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public void update(String id, Student student) {
          studentRepository.update(id,student);
    }

    @Override
    public void add(Student student) {

    }

    @Override
    public void remove(String id) {

    }
}
