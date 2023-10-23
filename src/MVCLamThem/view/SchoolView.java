package MVCLamThem.view;

import MVCLamThem.controller.IStudentController;
import MVCLamThem.controller.ITeacherController;
import MVCLamThem.controller.StudentController;
import MVCLamThem.controller.TeacherController;
import MVCLamThem.model.Student;
import MVCLamThem.model.Teacher;

import java.util.List;
import java.util.Scanner;

public class SchoolView {
    private final Scanner scanner = new Scanner(System.in);
    private final IStudentController studentController = new StudentController();
    private final ITeacherController teacherController = new TeacherController();

    public void showMenuStudent() {
        System.out.println("1. Thêm mới học sinh");
        System.out.println("2. Xóa học sinh");
        System.out.println("3. Hiển thị danh sách học sinh");
        System.out.println("4. Quay lại");
        System.out.println("Mời chọn");
    }

    public void showMenuTeacher() {
        System.out.println("1. Thêm mới giáo viên");
        System.out.println("2. Xóa giáo viên");
        System.out.println("3. Hiển thị danh sách giáo viên");
        System.out.println("4. Quay về");
    }

    public void showMenu() {
        System.out.println("Chương trình quản lý học sinh sinh viên");
        System.out.println("1. Quản lý học sinh");
        System.out.println("2. Quản lý giáo viên");
        System.out.println("3. Thoát");
    }

    public void runMenuTeacher() {
        int choice;
        do {
            try {
                showMenuTeacher();
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        teacherController.add(addTeacher());
                        break;
                    case 2:
                        teacherController.remove(inputIdTeacherRemove());
                        break;
                    case 3:
                        displayTeacher();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Vui lòng chọn 1 - 4");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public void runMenu() {
        int choiceMenu;
        do {
            try {
                showMenu();
                choiceMenu = Integer.parseInt(scanner.nextLine());
                switch (choiceMenu) {
                    case 1:
                        runMenuStudent();
                        break;
                    case 2:
                        runMenuTeacher();
                        break;
                    case 3:
                        System.exit(3);
                        break;
                    default:
                        System.out.println("Vui lòng nhập 1 - 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public void runMenuStudent() {
        int choiceStudent;
        do {
            try {
                showMenuStudent();
                choiceStudent = Integer.parseInt(scanner.nextLine());
                switch (choiceStudent) {
                    case 1:
                        studentController.add(addStudent());
                        break;
                    case 2:
                        studentController.remove(removeStudent());
                        break;
                    case 3:
                        displayStudent();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Vui lòng chọn 1 - 4");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    // phan su ly student
    public void displayStudent() {
        List<Student> studentList = studentController.getList();
        if (studentList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    public Student addStudent() {
        System.out.println("Nhập ID");
        String id = checkIdAdd();
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày sinh");
        String birthday = scanner.nextLine();
        System.out.println("Chọn giới tính");
        String gender = choiceGener();
        System.out.println("Nhập lớp");
        String classRom = scanner.nextLine();
        System.out.println("Nhập điểm số");
        int point = Integer.parseInt(scanner.nextLine());
        Student student = new Student(id, name, birthday, gender, classRom, point);
        System.out.println("Thêm thành công");
        return student;
    }

    public String removeStudent() {
        System.out.println("Nhập ID học viên cần xóa");
        String id = checkIdRemove();
        if (checkStatus()) {
            return id;
        }
        System.out.println("Bạn không xóa");
        return null;
    }

    public String checkIdAdd() {
        String id;
        int count = 0;
        List<Student> studentList = studentController.getList();
        do {
            id = scanner.nextLine();
            for (Student student : studentList) {
                if (student.getId().equals(id)) {
                    count++;
                }
            }
            if (count == 0) {
                return id;
            } else {
                System.out.println("ID đã tồn tại vui lòng nhập lại");
            }
        } while (true);
    }

    public String checkIdRemove() {
        String id;
        List<Student> studentList = studentController.getList();
        do {
            id = scanner.nextLine();
            for (Student student : studentList) {
                if (student.getId().equals(id)) {
                    return id;
                }
            }
            System.out.println("Không tìm thấy ID trong hệ thống vui lòng nhập lại");
        } while (true);
    }

    //Phan su ly teacher;
    public void displayTeacher() {
        List<Teacher> teacherList = teacherController.getList();
        if (teacherList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (Teacher teacher : teacherList) {
                System.out.println(teacher);
            }
        }
    }

    public Teacher addTeacher() {
        System.out.println("Nhập ID");
        String id = checkIdTeacherAdd();
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập birthday");
        String birthday = scanner.nextLine();
        System.out.println("Chọn giới tính");
        String gender = choiceGener();
        System.out.println("Nhập chuyên môn");
        String specialize = scanner.nextLine();
        Teacher teacher = new Teacher(id, name, birthday, gender, specialize);
        return teacher;
    }

    public String inputIdTeacherRemove() {
        System.out.println("Nhập ID cần xóa");
        String id = scanner.nextLine();
        if (checkStatus()) {
            return id;
        } else {
            System.out.println("Bạn không xóa");
        }
        return null;
    }

    public String checkIdTeacherAdd() {
        String id;
        int count = 0;
        List<Teacher> teacherList = teacherController.getList();
        do {
            id = scanner.nextLine();
            for (Teacher teacher : teacherList) {
                if (teacher.getId().equals(id)) {
                    count++;
                }
            }
            if (count == 0) {
                return id;
            } else {
                System.out.println("ID đã tồn tại trên hệ thống vui lòng nhập lại");
            }
        } while (true);
    }

    // Phan chung giua student va teacher;
    public boolean checkStatus() {
        System.out.println("Bạn có muốn xóa không Yes/No");
        int choice;
        do {
            try {
                System.out.println("1. Yes");
                System.out.println("2. No");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return true;
                    case 2:
                        return false;
                    default:
                        System.out.println("Vui lòng chọn 1 trong 2");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public String choiceGener() {
        String gender;
        int choice;
        do {
            try {
                System.out.println("1. Nam");
                System.out.println("2. Nữ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return "Nam";
                    case 2:
                        return "Nữ";
                    default:
                        System.out.println("Vui lòng chọn 1 trong 2");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }
}
