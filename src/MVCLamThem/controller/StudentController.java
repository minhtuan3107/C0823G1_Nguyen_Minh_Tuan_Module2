package MVCLamThem.controller;

import MVCLamThem.model.Student;
import MVCLamThem.service.IStudentService;
import MVCLamThem.service.StudentService;

import java.util.List;

public class StudentController implements IStudentController {
    private final IStudentService studentService = new StudentService();

    @Override
    public void add(Student student) {
        studentService.add(student);
    }

    @Override
    public void remove(String id) {
        studentService.remove(id);
    }

    @Override
    public List<Student> getList() {
        return studentService.getList();
    }
}
