package MVCLamThem.repository;

import MVCLamThem.model.Student;

import java.util.List;

public interface IStudentRepo {
    void add(Student student);

    void remove(String id);

    List<Student> getList();
}
