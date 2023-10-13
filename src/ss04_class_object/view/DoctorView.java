package ss04_class_object.view;

import ss04_class_object.controller.DoctorController;
import ss04_class_object.controller.IDoctorController;
import ss04_class_object.model.Doctor;

import java.util.List;
import java.util.Scanner;


public class DoctorView {
    private Scanner scanner = new Scanner(System.in);
    private IDoctorController doctorController = new DoctorController();

    public void displayMenu() {
        int choice;
        do {
            try {
                showMenu();
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        doctorController.add(add());
                        break;
                    case 2:
                        display(doctorController.getList());
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Nhập từ 1 - 3");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public void showMenu() {
        System.out.println("1. Thêm");
        System.out.println("2. Hiển thị");
    }

    public Doctor add() {
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi");
        int old = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập địa chỉ");
        String location = scanner.nextLine();
        System.out.println("Nhập email");
        String email = scanner.nextLine();
        System.out.println("Nhập số điện thoại");
        int phone = Integer.parseInt(scanner.nextLine());
        System.out.println("Chọn vị trí làm việc");
        String work = choiceWork();
        Doctor doctor = new Doctor(name, old, location, email, phone, work);
        return doctor;
    }

    public void display(List<Doctor> doctorList) {
        if (doctorList.size() == 0) {
            System.out.println("Danh sách rỗng");
        } else {
            for (Doctor doctor : doctorList) {
                System.out.println(doctor);
            }
        }
    }

    public String choiceWork() {
        try {
            System.out.println("Chọn vị trí làm việc");
            System.out.println("1. Y tá");
            System.out.println("2. Bác sỹ");
            System.out.println("3. Giám đốc");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    return "Y tá";
                case 2:
                    return "Bác sỹ";
                case 3:
                    return "Giám đốc";
                default:
                    System.out.println("Vui lòng chọn từ 1 - 3");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số");
        }
        return "Null";
    }
}
