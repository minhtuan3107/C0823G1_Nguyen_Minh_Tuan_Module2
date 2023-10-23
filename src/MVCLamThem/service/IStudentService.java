package MVCLamThem.service;

import MVCLamThem.model.Student;

import java.util.List;

public interface IStudentService {
    void add(Student student);

    void remove(String id);

    List<Student> getList();
}
