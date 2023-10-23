package MVCLamThem.service;

import MVCLamThem.model.Student;
import MVCLamThem.repository.IStudentRepo;
import MVCLamThem.repository.StudentRepo;

import java.util.List;

public class StudentService implements IStudentService {
    private final IStudentRepo studentRepo = new StudentRepo();

    @Override
    public void add(Student student) {
        studentRepo.add(student);
    }

    @Override
    public void remove(String id) {
        studentRepo.remove(id);
    }

    @Override
    public List<Student> getList() {
        return studentRepo.getList();
    }
}
