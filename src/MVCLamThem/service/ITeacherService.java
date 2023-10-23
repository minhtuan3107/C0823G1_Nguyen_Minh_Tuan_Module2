package MVCLamThem.service;

import MVCLamThem.model.Teacher;

import java.util.List;

public interface ITeacherService {
    void add(Teacher teacher);

    void remove(String id);

    List<Teacher> getList();
}
