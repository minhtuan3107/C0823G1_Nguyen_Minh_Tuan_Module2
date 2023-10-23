package MVCLamThem.service;

import MVCLamThem.model.Teacher;
import MVCLamThem.repository.ITeacherRepo;
import MVCLamThem.repository.TeacherRepo;

import java.util.List;

public class TeacherService implements ITeacherService{
    private final ITeacherRepo teacherRepo = new TeacherRepo();
    @Override
    public void add(Teacher teacher) {
        teacherRepo.add(teacher);
    }

    @Override
    public void remove(String id) {
        teacherRepo.remove(id);
    }

    @Override
    public List<Teacher> getList() {
        return teacherRepo.getList();
    }
}
