package Furama.view;

import Furama.controller.*;
import Furama.model.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class FuramaView {
    private static final Scanner scanner = new Scanner(System.in);
    private final EmployeeController employeeController = new EmployeeController();
    private final CustomerController customerController = new CustomerController();
    private final HouseController houseController = new HouseController();
    private final VillaController villaController = new VillaController();
    private final RoomController roomController = new RoomController();
    //Phan hien thi

    public void showFurama() {
        System.out.println("= FURAMA =");
        System.out.println("1. Quản lý nhân viên");
        System.out.println("2. Quản lý khách hàng");
        System.out.println("3. Quản lý cơ sở vật chất");
        System.out.println("Mời chọn");
    }

    public void showMenuFacility() {
        System.out.println("= Facility =");
        System.out.println("1. Quản lý House");
        System.out.println("2. Quản lý Room");
        System.out.println("3. Quản lý Villa");
        System.out.println("4. Thoát");
    }

    public void displayMenuFacility() {
        int choice;
        do {
            try {
                showMenuFacility();
                choice = parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayMenuHouse();
                        break;
                    case 2:
                        displayMenuRoom();
                        break;
                    case 3:
                        displayMenuVilla();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 4");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public void displayMenuVilla() {
        int choice;
        do {
            try {
                showMenuVilla();
                choice = parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        villaController.add(addVilla());
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 5");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public void displayMenuHouse() {
        int choice;
        do {
            try {
                showMenuHouse();
                choice = parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        houseController.add(addHouse());
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 5");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public void displayMenuRoom() {
        int choice;
        do {
            try {
                shoMenuRoom();
                choice = parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        roomController.add(addRoom());
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 5");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public void showMenuHouse() {
        System.out.println("1. Thêm mới House");
        System.out.println("2. Hiển thị House -- Đang update");
        System.out.println("3. Xóa House -- Đang update");
        System.out.println("4. Hiển thị danh sách House cần bảo trì -- Đang update");
        System.out.println("5. Trở lại");
    }

    public void shoMenuRoom() {
        System.out.println("1. Thêm mới Room");
        System.out.println("2. Hiển thị Room -- Đang update");
        System.out.println("3. Xóa room -- Đang update");
        System.out.println("4. Hiển thị danh sách Room bảo trì -- Đang update");
        System.out.println("5. Trở lại");
    }

    public void showMenuVilla() {
        System.out.println("1. Thêm mới Villa");
        System.out.println("2. Hiển thị Villa -- Đang update");
        System.out.println("3. Xóa Villa -- Đang update");
        System.out.println("4. Hiển thị danh sách Villa bảo trì -- Đang update");
        System.out.println("5. Trở lại");
    }

    public void displayFurama() {
        int choice;
        do {
            try {
                showFurama();
                choice = parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayMenuEmployee();
                        break;
                    case 2:
                        displayMenuCustomer();
                        break;
                    case 3:
                        displayMenuFacility();
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

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
                choice = parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayEmployee();
                        break;
                    case 2:
                        employeeController.add(addEmployee());
                        break;
                    case 3:
                        editEmployee();
                        break;
                    case 4:
                        employeeController.delete(inputIdDelete());
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
            }
        } while (true);
    }


    //Regex
    public boolean checkBirthday(String birthday) {
        LocalDate birthDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears() >= 18;
    }

    public boolean patternMatches(String check, String regex) {
        return Pattern.compile(regex).matcher(check).matches();
    }

    //Employee
    public String searchName() {
        System.out.println("Nhap ten can tim");
        String findName = checkEmpty();
        return findName;
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

    public void outputSearchCustomer() {
        List<Customer> customerList = customerController.search(searchName());
        if (customerList.isEmpty()) {
            System.out.println("Không tìm thấy");
        } else {
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        }
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

    public void editEmployee() {
        String idEdit = checkIdEdit();
        System.out.println("Nhập tên cần sửa");
        String name = checkName();
        System.out.println("Nhập birthday cần sửa");
        String birthday = checkBirthday();
        System.out.println("Chọn giới tính");
        String gender = choiceGender();
        System.out.println("Nhập CCCD cần sửa");
        int idNumber = idNumber();
        System.out.println("Nhập SDT cần sửa");
        int phone = checkPhone();
        System.out.println("Nhập email cần sửa");
        String email = checkEmail();
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

    public String inputIdEmployee() {
        List<Employee> employees = employeeController.getList();
        String text = null;
        String[] str;
        for (Employee employee : employees) {
            str = employee.getId().split("-");
            text = str[1];
        }
        int count = Integer.parseInt(text);
        return "NV-" + (count + 1);
    }

    public Employee addEmployee() {
        String idEmployee = inputIdEmployee();
        System.out.println("ID của bạn là: " + idEmployee);
        System.out.println("Nhập họ và tên Employee");
        String nameEmployee = checkName();
        System.out.println("Nhập birthday Employee");
        String birthdayEmployee = checkBirthday();
        System.out.println("Chọn giới tính");
        String gender = choiceGender();
        System.out.println("Nhập CCCD");
        int idNumber = idNumber();
        System.out.println("Nhập SDT ví dụ 0345323724");
        int phone = checkPhone();
        System.out.println("Nhập email");
        String email = checkEmail();
        System.out.println("Chọn trình độ học vấn");
        String level = choiceLevel();
        System.out.println("Chọn vị trí làm việc");
        String location = choiceLocation();
        int wage = inputWage(location);
        System.out.println("Mức lương của bạn khi làm " + location + " sẽ là: " + wage);
        Employee employee = new Employee(idEmployee, nameEmployee, birthdayEmployee, gender, idNumber, phone, email, level, location, wage);
        return employee;

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
        }
        return 50000000;
    }

    public String checkIdEdit() {
        String idEdit;
        do {
            System.out.println("Nhập ID cần sửa");
            idEdit = checkEmpty();
            if (!checkIdInput(idEdit)) {
                return idEdit;
            } else {
                System.out.println("Vui lòng nhập lại ID không tồn tại trên hệ thống");
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
                choice = parseInt(scanner.nextLine());
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
            }
        } while (true);
    }

    public int idNumber() {
        String idNumberCheck;
        String regexNummber = "^[0-9]{9,12}$";
        do {
            idNumberCheck = checkEmpty();
            if (patternMatches(idNumberCheck, regexNummber)) {
                return parseInt(idNumberCheck);
            } else {
                System.out.println("Vui lòng nhập đúng định dạng 9 - 12 số");
            }
        } while (true);
    }

    public String choiceGender() {
        int choice;
        do {
            try {
                System.out.println("1. Nam");
                System.out.println("2. Nữ");
                choice = parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return "Nam";
                    case 2:
                        return "Nữ";
                    default:
                        System.out.println("Nam hoặc Nữ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public String choiceLevel() {
        int choice;
        do {
            try {
                System.out.println("1. Trung cấp");
                System.out.println("2. Cao đẳng");
                System.out.println("3. Đại học");
                System.out.println("4. Sau đại học");
                choice = parseInt(scanner.nextLine());
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
            }
        } while (true);
    }

    public String checkEmail() {
        String email;
        String regexEmail = "^[\\w-\\.]+[0-9]+@(gmail\\.)+[\\w-]{3}$";
        do {
            email = checkEmpty();
            if (patternMatches(email, regexEmail)) {
                return email;
            } else {
                System.out.println("Vui lòng nhập đúng định dạng email");
            }
        } while (true);
    }

    public int checkPhone() {
        String phone;
        String regexPhone = "^(0){1}[3|5|7|8|9]{1}[0-9]{8}$"; // ^84\+[3|5|7|9]{1}[1-9]{8}$
        do {
            phone = checkEmpty();
            if (patternMatches(phone, regexPhone)) {
                return parseInt(phone);
            } else {
                System.out.println("Vui lòng nhập đúng định dạng sdt");
            }
        } while (true);
    }

    public String checkBirthday() {
        String birthday;
        do {
            try {
                birthday = checkEmpty();
                if (checkBirthday(birthday)) {
                    return birthday;
                } else {
                    System.out.println("Vui lòng nhập lại");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Vui lòng nhập đúng định dạng ngày tháng năm");
            }
        } while (true);
    }

    public String checkName() {
        String nameCheck;
        String regexName = "^[A-Z]{1}[a-z]{1,6}$";
        String[] arr;
        int count;
        do {
            nameCheck = checkEmpty();
            count = 0;
            arr = nameCheck.split(" ");
            for (String s : arr) {
                if (patternMatches(s, regexName)) {
                    count++;
                }
            }
            if (count == arr.length && arr.length >= 2 && arr.length <= 5) {
                return nameCheck;
            } else {
                System.out.println("Vui lòng nhập lại họ và tên");
            }
        } while (true);
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

    public String inputIdDelete() {
        System.out.println("Nhập ID cần xóa");
        String idDelete;
        do {
            idDelete = checkEmpty();
            if (!(checkIdInput(idDelete))) {
                System.out.println("Bạn có muốn xóa không y/n");
                if (checkStatus()) {
                    System.out.println("Xóa thành công");
                    return idDelete;
                }
            } else {
                System.out.println("Vui long nhap lai ID khong ton tai tren he thong");
            }
        } while (true);
    }

//    public String checkIdEmployee() {
//        String idCheck;
//        String regexId = "^(NV-)+[0-9]{4}$";
//        do {
//            idCheck = checkEmpty();
//            if (patternMatches(idCheck, regexId)) {
//                if (checkIdInput(idCheck)) {
//                    return idCheck;
//                } else {
//                    System.out.println("ID đã trùng trên hệ thống");
//                }
//            } else {
//                System.out.println("Vui lòng nhập đúng định dạng NV-1234");
//            }
//        } while (true);
//    }

    // Phan Customer
    public void showMenuCustomer() {
        System.out.println("= Quản lý khách hàng =");
        System.out.println("1. Hiển thị danh sách khách hàng");
        System.out.println("2. Thêm mới khách hàng");
        System.out.println("3. Sửa thông tin khách hàng");
        System.out.println("4. Xóa khách hàng");
        System.out.println("5. Tìm kiếm khách hàng");
        System.out.println("6. Trở về menu");
    }

    public void displayMenuCustomer() {
        Integer choice;
        do {
            try {
                showMenuCustomer();
                System.out.println("Mời nhập");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayCustomer();
                        break;
                    case 2:
                        customerController.add(addCustomer());
                        break;
                    case 3:
                        editCustomer();
                        break;
                    case 4:
                        customerController.delete(deleteIdCustomer());
                        break;
                    case 5:
                        outputSearchCustomer();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 6");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
                break;
            }
        } while (true);
    }

    public void displayCustomer() {
        List<Customer> customerList = customerController.getList();
        if (customerList.size() == 0) {
            System.out.println("Danh sách trống");
        } else {
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        }
    }


    public void editCustomer() {
        System.out.println("Nhập ID cần sửa");
        String id = checkIdEditCustomer();
        System.out.println("Nhập tên cần sửa");
        String name = checkName();
        System.out.println("Nhập Birthday cần sửa");
        String birthday = checkBirthday();
        System.out.println("Chọn giới tính");
        String gender = choiceGender();
        System.out.println("Nhập CCCD");
        int idNumber = idNumber();
        System.out.println("Nhập SDT");
        int phone = checkPhone();
        System.out.println("Nhập email");
        String email = checkEmail();
        System.out.println("Chọn loại khách hàng");
        String type = choiceTypeCustomer();
        System.out.println("Nhập địa chỉ");
        String address = checkEmpty();
        System.out.println("Bạn có muốn sửa không y/n ");
        if (!checkStatus()) {
            System.out.println("Sửa thành công");
            Customer customer = new Customer(id, name, birthday, gender, idNumber, phone, email, type, address);
            customerController.edit(id, customer);
        } else {
            System.out.println("Bạn không sửa");
        }
    }

    public String deleteIdCustomer() {
        System.out.println("Nhập ID cần xóa");
        String idDelete = checkIdEditCustomer();
        System.out.println("Bạn có muốn xóa không y/n");
        if (!checkStatus()) {
            return idDelete;
        } else {
            System.out.println("Bạn không xóa");
        }
        return null;
    }

    public String checkIdEditCustomer() {
        String id;
        do {
            id = checkEmpty();
            if (!checkIdCustomer(id)) {
                return id;
            } else {
                System.out.println("Vui lòng nhập lại ID không tồn tại");
            }
        } while (true);
    }


    public Customer addCustomer() {
        String idCustomer = inputIdCustomer();
        System.out.println("ID khách hàng của bạn là: " + idCustomer);
        System.out.println("Nhập họ và tên khách hàng");
        String name = checkName();
        System.out.println("Nhập birthday khách hàng");
        String birthday = checkBirthday();
        System.out.println("Chọn giới tính");
        String gender = choiceGender();
        System.out.println("Nhập số CCCD");
        int idNumber = idNumber();
        System.out.println("Nhập SDT");
        int phone = checkPhone();
        System.out.println("Nhập Email");
        String email = checkEmail();
        System.out.println("Chọn loại khách hàng");
        String type = choiceTypeCustomer();
        System.out.println("Nhập địa chỉ");
        String address = checkEmpty();
        Customer customer = new Customer(idCustomer, name, birthday, gender, idNumber, phone, email, type, address);
        System.out.println("Thêm mới khách hàng customer có thông tin : " + customer + " thành công");
        return customer;
    }

    public boolean checkIdCustomer(String id) {
        List<Customer> customerList = customerController.getList();
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                System.out.println(customer);
                return false;
            }
        }
        return true;
    }


    public String choiceTypeCustomer() {
        int choice;
        do {
            try {
                System.out.println("1. Diamond");
                System.out.println("2. Platinum");
                System.out.println("3. Gold");
                System.out.println("4. Sliver");
                System.out.println("5. Member");
                choice = parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return "Diamond";
                    case 2:
                        return "Platinum";
                    case 3:
                        return "Gold";
                    case 4:
                        return "Sliver";
                    case 5:
                        return "Member";
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 5");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    //    public String checkIdCustomer() {
//        String idCheck;
//        String regexId = "^(KH-)+[0-9]{4}$";
//        do {
//            idCheck = checkEmpty();
//            if (patternMatches(idCheck, regexId)) {
//                if (checkIdInput(idCheck)) {
//                    return idCheck;
//                } else {
//                    System.out.println("ID đã trùng trên hệ thống");
//                }
//            } else {
//                System.out.println("Vui lòng nhập đúng định dạng KH-1234");
//            }
//        } while (true);
//    }
    public String inputIdCustomer() {
        List<Customer> customerList = customerController.getList();
        String[] text;
        int count;
        String str = null;
        for (Customer customer : customerList) {
            text = customer.getId().split("-");
            str = text[1];
        }
        count = Integer.parseInt(str);
        return "KH-" + (count + 1);
    }

    public Villa addVilla() {
        System.out.println("Nhập mã dịch vụ");
        String id = checkIdVilla();
        System.out.println("Nhập tên dịch vụ");
        String name = nameServiceCheck();
        System.out.println("Nhập diện tích sử dụng");
        int area = areaCheck();
        System.out.println("Nhập chi phí thuê");
        int price = checkPrice();
        System.out.println("Nhập số lượng người");
        int people = checkPeople();
        System.out.println("Chọn kiểu thuê");
        String type = choiceType();
        System.out.println("Chọn tiêu chuẩn phòng");
        String standard = choiceStandard();
        System.out.println("Nhập diện tích hồ bơi");
        int areaPool = areaCheck();
        System.out.println("Nhập số tầng");
        int floor = checkFloor();
        return new Villa(id, name, area, price, people, type, standard, areaPool, floor);
    }

    public int checkFloor() {
        int floor;
        do {
            try {
                floor = parseInt(scanner.nextLine());
                if (floor > 1) {
                    return floor;
                } else {
                    System.out.println("Vui lòng nhập số lớn hơn 1");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public String choiceStandard() {
        int choice;
        do {
            try {
                System.out.println("1. *");
                System.out.println("2. **");
                System.out.println("3. ***");
                System.out.println("4. ****");
                System.out.println("5. *****");
                choice = parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return "1 sao";
                    case 2:
                        return "2 sao";
                    case 3:
                        return "3 sao";
                    case 4:
                        return "4 sao";
                    case 5:
                        return "5 sao";
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 5");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public String choiceType() {
        int choice;
        do {
            try {
                System.out.println("1. Thuê theo năm");
                System.out.println("2. Thuê theo tháng");
                System.out.println("3. Thuê theo ngày");
                System.out.println("4. Thuê theo giờ");
                choice = parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return "thuê theo năm";
                    case 2:
                        return "thuê theo tháng";
                    case 3:
                        return "thuê theo ngày";
                    case 4:
                        return "thuê theo giờ";
                    default:
                        System.out.println("Nhập từ 1 - 4");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public int checkPeople() {
        int people;
        do {
            try {
                people = parseInt(scanner.nextLine());
                if (people > 1 && people < 20) {
                    return people;
                } else {
                    System.out.println("Vui lòng nhập lớn hơn 0 và bé hơn 20");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public int checkPrice() {
        int price;
        do {
            try {
                price = parseInt(scanner.nextLine());
                if (price > 1) {
                    return price;
                } else {
                    System.out.println("Vui lòng nhập số dương");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public int areaCheck() {
        int area;
        do {
            try {
                area = parseInt(scanner.nextLine());
                if (area >= 30) {
                    return area;
                } else {
                    System.out.println("Vui lòng nhập diện tích lớn hơn 30");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public String nameServiceCheck() {
        String nameCheck;
        String regexId = "^([A-Z])[a-z ]+$";
        do {
            nameCheck = checkEmpty();
            if (patternMatches(nameCheck, regexId)) {
                return nameCheck;
            } else {
                System.out.println("Vui lòng nhập đúng định dạng viết hoa kí tự đầu ");
            }
        } while (true);
    }

    public String checkIdVilla() {
        String idCheck;
        String regexId = "^(SVVL-)+[0-9]{1}";
        do {
            idCheck = checkEmpty();
            if (patternMatches(idCheck, regexId)) {
                return idCheck;
            } else {
                System.out.println("Vui lòng nhập đúng định dạng SVVL-1");
            }
        } while (true);
    }

    public Room addRoom() {
        System.out.println("Nhập ID room");
        String roomId = checkIdRoom();
        System.out.println("Nhập tên dịch vụ");
        String name = nameServiceCheck();
        System.out.println("Nhập diện tích sử dụng");
        int area = areaCheck();
        System.out.println("Nhập chi phí thuê");
        int price = checkPrice();
        System.out.println("Nhập số lượng người ở");
        int people = checkPeople();
        System.out.println("Chọn kiểu thuê");
        String type = choiceType();
        System.out.println("Chọn dịch vụ miễn phí");
        String serviceFree = choiceServiceFree();
        return new Room(roomId, name, area, price, people, type, serviceFree);
    }

    public String choiceServiceFree() {
        int choice;
        do {
            try {
                System.out.println("1.Nuoc uong mien phi");
                System.out.println("2.Phuong tien di lai mien phi");
                choice = parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return "Nuoc uong mien phi";
                    case 2:
                        return "Phuong tien di lai mien phi";
                    default:
                        System.out.println("Nhập 1 - 2");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public String checkIdRoom() {
        String idRoom;
        String regexId = "^(SVRO-)+[0-9]{1}";
        do {
            idRoom = checkEmpty();
            if (patternMatches(idRoom, regexId)) {
                return idRoom;
            } else {
                System.out.println("Vui lòng nhập đúng định dạng SVRO-1");
            }
        } while (true);
    }

    public String checkIdHouse() {
        String idHouse;
        String regexId = "^(SVHO-)+[0-9]{1}";
        do {
            idHouse = checkEmpty();
            if (patternMatches(idHouse, regexId)) {
                return idHouse;
            } else {
                System.out.println("Vui lòng nhập đúng định dạng SVHO-1");
            }
        } while (true);
    }

    public House addHouse() {
        System.out.println("Nhập mã dịch vụ House");
        String idHouse = checkIdHouse();
        System.out.println("Nhập tên dịch vụ");
        String name = nameServiceCheck();
        System.out.println("Nhập diện tích sử dụng");
        int area = areaCheck();
        System.out.println("Nhập chi phí thuê");
        int price = checkPrice();
        System.out.println("Nhập số lượng người");
        int people = checkPeople();
        System.out.println("Chọn kiểu thuê");
        String type = choiceType();
        System.out.println("Chọn tiêu chuẩn phòng");
        String standard = choiceStandard();
        System.out.println("Nhập số tầng");
        int floor = checkFloor();
        return new House(idHouse, name, area, price, people, type, standard, floor);
    }

    public String checkEmpty() {
        String str;
        String[] strs;
        do {
            str = scanner.nextLine();
            strs = str.split("");
            if (!(str.isEmpty())) {
                return str;
            } else {
                System.out.println("Vui lòng nhập không để rỗng");
            }
        } while (true);
    }
}

