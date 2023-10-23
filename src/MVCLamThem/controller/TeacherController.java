package MVCLamThem.controller;

import MVCLamThem.model.Teacher;
import MVCLamThem.service.ITeacherService;
import MVCLamThem.service.TeacherService;

import java.util.List;

public class TeacherController implements ITeacherController {
    private final ITeacherService teacherService = new TeacherService();

    @Override
    public void add(Teacher teacher) {
        teacherService.add(teacher);
    }

    @Override
    public void remove(String id) {
        teacherService.remove(id);
    }

    @Override
    public List<Teacher> getList() {
        return teacherService.getList();
    }
}
