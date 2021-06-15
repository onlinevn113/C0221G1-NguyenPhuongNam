package model.service.impl;

import model.bean.Student;
import model.repository.StudentRepository;
import model.service.IStudentService;
import model.service.common.Regex;

import java.time.Year;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements IStudentService {
    StudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> findByAll() {
        return studentRepository.findByAll();
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public Map<String, String> create(Student student) {
        Map<String, String> mapMsg = new HashMap<>();
        Regex regex = new Regex();
        boolean flag = true;
        if ("".equals(student.getName())) {
            mapMsg.put("nameMsg", "Please input name");
            flag = false;
        } else if (!student.getName().matches(regex.NAME)) {
            mapMsg.put("nameMsg", "Please input invalid format");
            flag = false;
        }


        if ("".equals(student.getGender())) {
            mapMsg.put("genderMsg", "Please input gender");
            flag = false;
        }


        if ("".equals(student.getBirthday())) {
            mapMsg.put("birthdayMsg", "Please input birthday");
            flag = false;
        } else if (!student.getBirthday().matches(regex.DATE)) {
            mapMsg.put("birthdayMsg", "Please input invalid format");
            flag = false;
        } else {
            String[] birthday = student.getBirthday().split("-");
            int year = Integer.parseInt(birthday[0]);
            int yearNow = Year.now().getValue();
            if (!(yearNow - year > 18 && yearNow - year < 120)) {
                mapMsg.put("birthdayMsg", "Please input age from 18 to 120");
                flag = false;
            }
        }


        if ("".equals(student.getEmail())) {
            mapMsg.put("emailMsg", "Please input email");
            flag = false;
        } else if (!student.getEmail().matches(regex.EMAIL)) {
            mapMsg.put("emailMsg", "Please input invalid format");
            flag = false;
        }

        if ("".equals(student.getAddress())) {
            mapMsg.put("addressMsg", "Please input address");
            flag = false;
        } else if (!student.getAddress().matches(regex.ADDRESS)) {
            mapMsg.put("addressMsg", "Please input invalid format");
            flag = false;
        }

        if (flag) {
            studentRepository.create(student);
        }
        return mapMsg;
    }

    @Override
    public boolean delete(int id) {
        return studentRepository.delete(id);
    }

    @Override
    public Map<String, String> edit(Student student) {
        Map<String, String> mapMsg = new HashMap<>();
        Regex regex = new Regex();
        boolean flag = true;


        if ("".equals(student.getName())) {
            mapMsg.put("nameMsg", "Please input name");
            flag = false;
        } else if (!student.getName().matches(regex.NAME)) {
            mapMsg.put("nameMsg", "Please input invalid format");
            flag = false;
        }

        if ("".equals(student.getGender())) {
            mapMsg.put("genderMsg", "Please input gender");
            flag = false;
        }


        if ("".equals(student.getBirthday())) {
            mapMsg.put("birthdayMsg", "Please input birthday");
            flag = false;
        } else if (!student.getBirthday().matches(regex.DATE)) {
            mapMsg.put("birthdayMsg", "Please input invalid format");
            flag = false;
        } else {
            String[] birthday = student.getBirthday().split("-");
            int year = Integer.parseInt(birthday[0]);
            int yearNow = Year.now().getValue();
            if (!(yearNow - year > 18 && yearNow - year < 120)) {
                mapMsg.put("birthdayMsg", "Please input age from 18 to 120");
                flag = false;
            }
        }


        if ("".equals(student.getEmail())) {
            mapMsg.put("emailMsg", "Please input email");
            flag = false;
        } else if (!student.getEmail().matches(regex.EMAIL)) {
            mapMsg.put("emailMsg", "Please input invalid format");
            flag = false;
        }


        if ("".equals(student.getAddress())) {
            mapMsg.put("addressMsg", "Please input address");
            flag = false;
        } else if (!student.getAddress().matches(regex.ADDRESS)) {
            mapMsg.put("addressMsg", "Please input invalid format");
            flag = false;
        }

        if (flag) {
            studentRepository.edit(student);
        }
        return mapMsg;
    }
}
