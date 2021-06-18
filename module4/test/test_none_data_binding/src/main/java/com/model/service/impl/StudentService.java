package com.model.service.impl;

import com.model.bean.Student;
import com.model.service.IStudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentService  implements IStudentService {

    @Override
    public Student save(Student student) {
        return student;
    }
}
