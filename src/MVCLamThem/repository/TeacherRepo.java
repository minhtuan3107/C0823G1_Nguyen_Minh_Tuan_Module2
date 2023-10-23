package MVCLamThem.repository;

import MVCLamThem.utils.ReadAndWrite;
import MVCLamThem.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepo implements ITeacherRepo {
    private final String COMMA = ",";
    private final String FILE = "D:\\module2Again\\src\\MVCLamThem\\Untils\\dataTeacher";

    @Override
    public void add(Teacher teacher) {
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher);
        ReadAndWrite.write(convertToString(teacherList), FILE, true);
    }

    @Override
    public void remove(String id) {
        List<Teacher> teacherList = getList();
        for (Teacher teacher : teacherList) {
            if (teacher.getId().equals(id)) {
                teacherList.remove(teacher);
                break;
            }
        }
        ReadAndWrite.write(convertToString(teacherList), FILE, false);
    }

    @Override
    public List<Teacher> getList() {
        List<String> stringList = ReadAndWrite.read(FILE);
        List<Teacher> teacherList = convertToObject(stringList);
        return teacherList;
    }

    public List<String> convertToString(List<Teacher> teacherList) {
        List<String> stringList = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            stringList.add(teacher.getId() + COMMA
                    + teacher.getName() + COMMA
                    + teacher.getBirthday() + COMMA
                    + teacher.getGender() + COMMA +
                    teacher.getSpecialize());
        }
        return stringList;
    }

    public List<Teacher> convertToObject(List<String> stringList) {
        List<Teacher> teacherList = new ArrayList<>();
        String[] line;
        for (String str : stringList) {
            line = str.split(",");
            teacherList.add(new Teacher(line[0], line[1], line[2], line[3], line[4]));
        }
        return teacherList;
    }
}
