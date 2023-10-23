package MVCLamThem.repository;

import MVCLamThem.model.Teacher;

import java.util.List;

public interface ITeacherRepo {
    void add(Teacher teacher);

    void remove(String id);

    List<Teacher> getList();
}
