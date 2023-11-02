package case_studyTest.view;

import case_studyTest.controller.EmployeeController;
import case_studyTest.model.person.Employee;
import case_studyTest.util.Regex;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class EmployeeManagerView {
    private final EmployeeController employeeController = new EmployeeController();
    private final Scanner scanner = new Scanner(System.in);


    public void displayEmployeeMenu() {
        System.out.println("---Employee Menu---");
        System.out.println("1. Hiển thị danh sách employee");
        System.out.println("2. Thêm mới employee");
        System.out.println("3. Sửa employee");
        System.out.println("4. Xóa employee");
        System.out.println("5. Tim kiếm employee");
        System.out.println("6. Trở về menu");
    }

    public int inputOption() {
        int option = 0;
        do {
            try {
                System.out.println("Mời chọn");
                option = Integer.parseInt(scanner.nextLine());
                if (option > 6 || option <= 0) {
                    System.out.println("Vui lòng chọn từ 1 - 6");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (option <= 0 || option > 6);
        return option;
    }

    public void employeeManagement(int option) {
        switch (option) {
            case 1:
                System.out.println(employeeController.display());
                break;
            case 2:
                employeeController.add(inputEmployee());
                break;
            case 3:
                System.out.println("Nhập ID ");
                String id = scanner.nextLine();
                if (checkId(id)) {
                    Employee employee = new Employee();
                    employee.setIdEmployee(id);
                    employee.setName(inputName());
                    employee.setDateOfBirth(inputDayOfBirth());
                    employee.setGender(inputGender());
                    employee.setIdCard(inputIdCard());
                    employee.setPhoneNumber(inputPhoneNumber());
                    employee.setEmail(inputEmail());
                    employee.setAcademicLevel(inputAcademicLevel());
                    employee.setJobPosition(inputJobPosition());
                    employee.setSalary(inputSalary());
                    employeeController.edit(employee);
                } else {
                    System.out.println("Không tìm thấy ID");
                }
                break;
            case 4:
                System.out.println("Nhập ID :");
                String idDelete = scanner.nextLine();
                if (checkId(idDelete)) {
                    employeeController.delete(idDelete);
                } else {
                    System.out.println("Không tìm thấy ID ");
                }
                break;
            case 5:
                System.out.println("Nhập tên :");
                String name = scanner.nextLine();
                System.out.println(employeeController.searchByName(name));
                break;
            case 6:
                break;
            default:
                System.out.println("Vui lòng nhập từ 1 - 6");
        }
    }

    public void employeeMenu() {
        int temp;
        do {
            displayEmployeeMenu();
            temp = inputOption();
            employeeManagement(temp);
        } while (temp != 6);
    }

    public Employee inputEmployee() {
        Employee employee = new Employee();
        employee.setIdEmployee(inputId());
        employee.setName(inputName());
        employee.setDateOfBirth(inputDayOfBirth());
        employee.setGender(inputGender());
        employee.setIdCard(inputIdCard());
        employee.setPhoneNumber(inputPhoneNumber());
        employee.setEmail(inputEmail());
        employee.setAcademicLevel(inputAcademicLevel());
        employee.setJobPosition(inputJobPosition());
        employee.setSalary(inputSalary());
        return employee;
    }


    public boolean checkId(String id) {
        for (Employee employee : employeeController.display()) {
            if (employee.getIdEmployee().equals(id)) {
                return true;
            }
        }
        return false;
    }


    public String inputId() {
        String id = "NV-";
        String inputId;
        do {
            System.out.println(id + " Nhập ID nhân viên gồm 4 số :");
            inputId = scanner.nextLine();
            if (!Regex.codeValidate(inputId)) {
                System.out.println("Invalid id");
            } else {
                if (checkId(id.concat(inputId))) {
                    System.out.println("ID đã tồn tại vui lòng nhập lại ");
                } else {
                    break;
                }
            }
        } while (true);
        return id;
    }

    public String inputName() {
        String name;
        do {
            System.out.println("Nhập tên employee");
            name = scanner.nextLine();
        } while (!Regex.nameValidate(name));
        return name;
    }

    public String inputDayOfBirth() {
        String dOB = null;
        boolean check;
        do {
            check = false;
            try {
                System.out.println("Nhập birthday Employee");
                dOB = scanner.nextLine();
                if (Regex.is18YearsOld(dOB)) {
                    check = true;
                } else {
                    System.out.println("Vui lòng nhập trên 18t");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Sai định dạng birthday");
            }
        } while (!Regex.dOBValidate(dOB) || !check);
        return dOB;
    }

    public String inputGender() {
        String gender;
        do {
            System.out.println("Nhập giới tính");
            gender = scanner.nextLine();
        } while (!Regex.genderValidate(gender));
        return gender;
    }

    public String inputIdCard() {
        String idCard;
        do {
            System.out.println("Nhập CCCD 9 - 12 số ");
            idCard = scanner.nextLine();
        } while (!Regex.idCardValidate(idCard));
        return idCard;
    }

    public String inputPhoneNumber() {
        String phoneNumber;
        do {
            System.out.println("Nhập SDT");
            phoneNumber = scanner.nextLine();
        } while (!Regex.phoneNumberValidate(phoneNumber));
        return phoneNumber;
    }

    public String inputEmail() {
        String email;
        do {
            System.out.println("Nhập email");
            email = scanner.nextLine();
        } while (!Regex.emailValidate(email));
        return email;
    }

    public String inputSalary() {
        String salary;
        do {
            System.out.println("Nhập mức lương");
            salary = scanner.nextLine();
        } while (!Regex.salaryValidate(salary));
        return salary;
    }

    public String inputAcademicLevel() {
        String academicLevel = null;
        System.out.println("Nhập trình độ học vấn");
        System.out.println("1. Trung cấp");
        System.out.println("2. Cao đẳng");
        System.out.println("3. Đại học");
        System.out.println("4. Sau đại học");
        int choice;
        while (true) {
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    academicLevel = "Trung cấp";
                    break;
                case 2:
                    academicLevel = "Cao đẳng";
                    break;
                case 3:
                    academicLevel = "Đại học";
                    break;
                case 4:
                    academicLevel = "Sau đại học";
                    break;
                default:
                    System.out.println("Vui lòng chọn 1 - 4");
            }
            break;
        }
        return academicLevel;
    }

    public String inputJobPosition() {
        String jobPosition = null;
        System.out.println("Chọn vị trí làm việc ");
        System.out.println("1. Lễ tân");
        System.out.println("2. Phục vụ");
        System.out.println("3. Chuyên viên");
        System.out.println("4. Giám sát");
        System.out.println("5. Quản lý");
        System.out.println("6. Giám đốc");
        int choice;
        while (true) {
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    jobPosition = "Lễ tân";
                    break;
                case 2:
                    jobPosition = "Phục vụ";
                    break;
                case 3:
                    jobPosition = "Chuyên viên";
                    break;
                case 4:
                    jobPosition = "Giám sát";
                    break;
                case 5:
                    jobPosition = "Quản lý";
                    break;
                case 6:
                    jobPosition = "Giám đốc";
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1 - 6");
            }
            break;
        }
        return jobPosition;
    }
}
