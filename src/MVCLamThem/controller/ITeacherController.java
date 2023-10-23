package MVCLamThem.controller;

import MVCLamThem.model.Teacher;

import java.util.List;

public interface ITeacherController {
    void add(Teacher teacher);

    void remove(String id);

    List<Teacher> getList();
}
