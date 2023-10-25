package MVCLamThem.repository;

import Furama.utils.ReadAndWrite;
import MVCLamThem.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements IStudentRepo {
    private final String COMMA = ",";
    private final String FILE = "D:\\module2Again\\src\\MVCLamThem\\Untils\\data123";

    @Override
    public void add(Student student) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        ReadAndWrite.write(convertToString(studentList), FILE, false);
    }

    @Override
    public void remove(String id) {
        List<Student> studentList = getList();
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentList.remove(student);
                break;
            }
        }
        ReadAndWrite.write(convertToString(studentList), FILE, true);
    }

    @Override
    public List<Student> getList() {
        List<String> stringList = ReadAndWrite.read(FILE);
        List<Student> studentList = convertToObject(stringList);
        return studentList;
    }

    public List<String> convertToString(List<Student> students) {
        List<String> stringList = new ArrayList<>();
        for (Student student : students) {
            stringList.add(student.getId() + COMMA
                    + student.getName() + COMMA
                    + student.getBirthday() + COMMA
                    + student.getGender() + COMMA
                    + student.getClassRom() + COMMA
                    + student.getPoint());
        }
        return stringList;
    }

    public List<Student> convertToObject(List<String> stringList) {
        List<Student> students = new ArrayList<>();
        String[] line;
        for (String str : stringList) {
            line = str.split(",");
            students.add(new Student(line[0], line[1], line[2], line[3], line[4], Integer.parseInt(line[5])));
        }
        return students;
    }
}
