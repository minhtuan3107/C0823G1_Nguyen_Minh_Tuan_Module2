package Furama.views;

import Furama.controllers.EmployeeController;
import Furama.models.person.Employee;
import Furama.utils.Validate;

import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    private final EmployeeController employeeController = new EmployeeController();
    private final Scanner scanner = new Scanner(System.in);
    private final Validate validate = new Validate();

    public void showMenuEmployee() {
        System.out.println("= Quản lý nhân viên =");
        System.out.println("1.Hiển thị danh sách nhân viên");
        System.out.println("2.Thêm mới nhân viên");
        System.out.println("3.Chỉnh sửa nhân viên");
        System.out.println("4.Xóa nhân viên");
        System.out.println("5.Tìm kiếm tên nhân viên");
        System.out.println("6.Trở về menu");
    }

    public void displayMenuEmployee() {
        int choice;
        do {
            try {
                showMenuEmployee();
                System.out.println("Mời nhập");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayEmployee();
                        break;
                    case 2:
                        if (employeeController.add(addEmployee())) {
                            System.out.println("Thêm thành công");
                        } else {
                            System.out.println("Thêm không thành công vui lòng thử lại");
                            return;
                        }
                        break;
                    case 3:
                        choiceEditEmployee();
                        break;
                    case 4:
                        System.out.println("Nhập ID cần xóa");
                        String idDel = checkIdLive();
                        System.out.println("Bạn có muốn xóa không ? y/n");
                        if (checkStatus()) {
                            if (employeeController.delete(idDel)) {
                                System.out.println("Xóa thành công");
                            } else {
                                System.out.println("Xóa không thành công vui lòng thử lại");
                                return;
                            }
                        } else {
                            System.out.println("Bạn không xóa");
                            return;
                        }
                        break;
                    case 5:
                        outputSearchEmployee();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 6");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        } while (true);
    }

    public void outputSearchEmployee() {
        List<Employee> employees = employeeController.search(searchName());
        if (employees.isEmpty()) {
            System.out.println("Không tìm thấy");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public String searchName() {
        System.out.println("Nhap ten can tim");
        return validate.checkEmpty();
    }

    public void displayEmployee() {
        List<Employee> employees = employeeController.getList();
        if (employees.size() == 0) {
            System.out.println("Danh sách trống");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public Employee addEmployee() {
        String idEmployee = inputIdEmployee();
        System.out.println("ID của bạn là: " + idEmployee);
        System.out.println("Nhập họ và tên Employee");
        String nameEmployee = validate.checkName();
        System.out.println("Nhập birthday Employee");
        String birthdayEmployee = validate.checkBirthday();
        System.out.println("Chọn giới tính");
        String gender = validate.choiceGender();
        System.out.println("Nhập CCCD");
        int idNumber = validate.idNumber();
        System.out.println("Nhập SDT ví dụ 0345323724");
        int phone = validate.checkPhone();
        System.out.println("Nhập email");
        String email = validate.checkEmail();
        System.out.println("Chọn trình độ học vấn");
        String level = choiceLevel();
        System.out.println("Chọn vị trí làm việc");
        String location = choiceLocation();
        int wage = inputWage(location);
        System.out.println("Mức lương của bạn khi làm " + location + " sẽ là: " + wage);
        return new Employee(idEmployee, nameEmployee, birthdayEmployee, gender, idNumber, phone, email, level, location, wage);
    }

    public String inputIdEmployee() {
        List<Employee> employees = employeeController.getList();
        String[] str;
        int count = 0;
        for (Employee employee : employees) {
            str = employee.getId().split("-");
            count = Integer.parseInt(str[1]);
        }
        if (count <= 9) {
            return "NV-000" + (count + 1);
        } else if (count <= 99) {
            return "NV-00" + (count + 1);
        } else if (count <= 999) {
            return "NV-0" + (count + 1);
        } else {
            return "NV-" + (count + 1);
        }
    }

    public String choiceLevel() {
        int choice;
        do {
            try {
                System.out.println("1. Trung cấp");
                System.out.println("2. Cao đẳng");
                System.out.println("3. Đại học");
                System.out.println("4. Sau đại học");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return "Trung cấp";
                    case 2:
                        return "Cao đẳng";
                    case 3:
                        return "Đại học";
                    case 4:
                        return "Sau đại học";
                    default:
                        System.out.println("Nhập từ 1 - 4");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        } while (true);
    }

    public String choiceLocation() {
        int choice;
        do {
            try {
                System.out.println("1. Lễ tân");
                System.out.println("2. Phục vụ");
                System.out.println("3. Chuyên viên");
                System.out.println("4. Giám sát");
                System.out.println("5. Quản lý");
                System.out.println("6. Giám đốc");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return "Lễ tân";
                    case 2:
                        return "Phục vụ";
                    case 3:
                        return "Chuyên viên";
                    case 4:
                        return "Giám sát";
                    case 5:
                        return "Quản lý";
                    case 6:
                        return "Giám đốc";
                    default:
                        System.out.println("Vui lòng nhập từ 1 -6");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        } while (true);
    }

    public int inputWage(String location) {
        switch (location) {
            case "Lễ tân":
                return 7000000;
            case "Phục vụ":
                return 8000000;
            case "Chuyên viên":
                return 9000000;
            case "Giám sát":
                return 10000000;
            case "Quản lý":
                return 15000000;
            case "Giám đốc":
                return 50000000;
        }
        return 0;
    }

    public void choiceEditEmployee() {
        int choice;
        do {
            try {
                System.out.println("Chọn chức năng sửa");
                System.out.println("1. Chỉnh sửa tất cả");
                System.out.println("2. Chỉnh sửa một phần ");
                System.out.println("3. Thoát edit");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        editEmployee();
                        break;
                    case 2:
                        editEmployeeV1();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Chọn 1 - 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        } while (true);
    }

    public void editEmployeeV1() {
        int choice;
        System.out.println("Nhập ID cần sửa");
        String idEdit = checkIdLive();
        List<Employee> employees = employeeController.getList();
        for (Employee employee : employees) {
            if (employee.getId().equals(idEdit)) {
                do {
                    try {
                        System.out.println("1. Sửa tên: " + employee.getName());
                        System.out.println("2. Sửa birthday: " + employee.getBirthday());
                        System.out.println("3. Sửa giới tính: " + employee.getGender());
                        System.out.println("4. Sửa CCCD: " + employee.getIdNumber());
                        System.out.println("5. Sửa Sdt: " + employee.getPhone());
                        System.out.println("6. Sửa Email: " + employee.getEmail());
                        System.out.println("7. Sửa trình độ: " + employee.getLevel());
                        System.out.println("8. Sửa vị trí làm việc: " + employee.getLocation());
                        System.out.println("9. Thoát edit");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                System.out.println("Nhập tên");
                                employee.setName(validate.checkName());
                                break;
                            case 2:
                                System.out.println("Nhập birthday");
                                employee.setBirthday(validate.checkBirthday());
                                break;
                            case 3:
                                System.out.println("Chọn giới tính");
                                employee.setGender(validate.choiceGender());
                                break;
                            case 4:
                                System.out.println("Nhập CCCD");
                                employee.setIdNumber(validate.idNumber());
                                break;
                            case 5:
                                System.out.println("Nhập SDT");
                                employee.setPhone(validate.checkPhone());
                                break;
                            case 6:
                                System.out.println("Nhập Email");
                                employee.setEmail(validate.checkEmail());
                                break;
                            case 7:
                                System.out.println("7. Chọn trình độ");
                                employee.setLevel(choiceLevel());
                                break;
                            case 8:
                                System.out.println("8. Chọn vị trí làm việc");
                                employee.setLocation(choiceLocation());
                                employee.setWage(inputWage(employee.getLocation()));
                                break;
                            case 9:
                                return;
                            default:
                                System.out.println("Vui lòng chọn 1 - 8");
                        }
                        employeeController.edit(idEdit, employee);
                    } catch (NumberFormatException e) {
                        System.out.println("Vui lòng nhập số");
                    } catch (Exception e) {
                        System.out.println("Lỗi không xác định");
                    }
                } while (true);
            }
        }
    }

    public void editEmployee() {
        System.out.println("Nhập ID cần sửa");
        String idEdit = checkIdLive();
        System.out.println("Nhập tên cần sửa");
        String name = validate.checkName();
        System.out.println("Nhập birthday cần sửa");
        String birthday = validate.checkBirthday();
        System.out.println("Chọn giới tính");
        String gender = validate.choiceGender();
        System.out.println("Nhập CCCD cần sửa");
        int idNumber = validate.idNumber();
        System.out.println("Nhập SDT cần sửa");
        int phone = validate.checkPhone();
        System.out.println("Nhập email cần sửa");
        String email = validate.checkEmail();
        System.out.println("Chọn trình độ học vấn");
        String level = choiceLevel();
        System.out.println("Chọn vị trí làm việc");
        String location = choiceLocation();
        int wage = inputWage(location);
        System.out.println("Mức lương của bạn khi làm " + location + " sẽ là: " + wage);
        System.out.println("Bạn có muốn sửa không y/n");
        if (checkStatus()) {
            System.out.println("Sửa thành công");
            Employee employee = new Employee(idEdit, name, birthday, gender, idNumber, phone, email, level, location, wage);
            employeeController.edit(idEdit, employee);
        } else {
            System.out.println("Bạn không sửa");
        }
    }


    public boolean checkIdInput(String id) {
        List<Employee> employeeList = employeeController.getList();
        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkStatus() {
        String check = scanner.nextLine();
        if (check.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    public String checkIdLive() {
        String id;
        do {
            id = validate.checkEmpty();
            if (!checkIdInput(id)) {
                return id;
            } else {
                System.out.println("Vui lòng nhập lại ID không tồn tại trên hệ thống");
            }
        } while (true);
    }
}
