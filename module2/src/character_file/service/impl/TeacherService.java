package character_file.service.impl;

import character_file.model.Teacher;
import character_file.service.ITeacherService;



import java.util.List;

public class TeacherService implements ITeacherService {
    @Override
    public boolean add(Teacher teacher) {
        return false;
    }

    @Override
    public boolean edit(Teacher teacher, int index) {
        return false;
    }

    @Override
    public boolean delete(int index) {
        return false;
    }

    @Override
    public List<Teacher> list() {
        return null;
    }

    @Override
    public Teacher inputAddOrEdit() {
        return null;
    }
}
