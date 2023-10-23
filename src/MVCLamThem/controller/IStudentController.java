package MVCLamThem.controller;

import MVCLamThem.model.Student;

import java.util.List;

public interface IStudentController {
    void add(Student student);

    void remove(String id);

    List<Student> getList();
}
