package model.repository;

import model.bean.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {
    static Map<String,Student> map = new HashMap<>();
    static {
        map.put("1",new Student("1","toàn1",23,"toan@gmail.com"));
        map.put("2",new Student("2","toàn2",23,"toan@gmail.com"));
        map.put("3",new Student("3","toàn3",23,"toan@gmail.com"));
        map.put("4",new Student("4","toàn4",23,"toan@gmail.com"));
        map.put("5",new Student("5","toàn5",23,"toan@gmail.com"));
    }
    public List<Student> findByAll() {
        // kết nối databe=> lấy lại cái danh sách
        return new ArrayList<>(map.values());
    }

    public Student findById(String id) {

        return map.get(id);
    }

    public void update(String id, Student student) {
         map.put(id,student);
    }
    public void add(Student student) {

    }

    public void remove(String id) {

    }
}
