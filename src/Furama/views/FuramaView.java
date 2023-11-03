package Furama.views;

import Furama.controllers.*;
import Furama.models.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FuramaView {
    private static final Scanner scanner = new Scanner(System.in);
    private final EmployeeController employeeController = new EmployeeController();
    private final CustomerController customerController = new CustomerController();
    private final FacilityController facilityController = new FacilityController();
    private final BookingController bookingController = new BookingController();
    private final ContractController contractController = new ContractController();
    //Phan hien thi

    public void showFurama() {
        System.out.println("= FURAMA =");
        System.out.println("1. Quản lý nhân viên");
        System.out.println("2. Quản lý khách hàng");
        System.out.println("3. Quản lý cơ sở vật chất");
        System.out.println("4. Quản lý booking");
        System.out.println("5. Thoát");
        System.out.println("Mời chọn");
    }

    public void showMenuBooking() {
        System.out.println("1. Thêm mới booking");
        System.out.println("2. Hiển thị danh sách booking");
        System.out.println("3. Tạo mới hợp đồng");
        System.out.println("4. Hiển thị danh sách hợp đồng");
        System.out.println("5. Sửa hợp đồng ");
        System.out.println("6. Quay về");
    }

    public void showMenuFacility() {
        System.out.println("1. Hiển thị list Facility");
        System.out.println("2. Thêm mới Facility");
        System.out.println("3. Hiển thị danh sách Facility cần bảo trì");
        System.out.println("4. Xóa facility");
        System.out.println("5. Quay về");
    }

    public void displayMenuBooking() {
        int choice;
        do {
            try {
                showMenuBooking();
                System.out.println("Mời chọn");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        bookingController.add(addBooking());
                        break;
                    case 2:
                        displayBooking();
                        break;
                    case 3:
                        contractController.add(addContract());
                        break;
                    case 4:
                        displayContract();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 5 ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public void displayMenuFacility() {
        int choice;
        do {
            try {
                showMenuFacility();
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayFacility();
                        break;
                    case 2:
                        displayMenuAddFacility();
                        break;
                    case 3:
                        displayListMaintenance();
                        break;
                    case 4:
                        facilityController.delete(removeFacility());
                        break;
                    case 5:
                        editContract();
                        return;
                    default:
                        System.out.println("Vui lòng chọn 1 - 5");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public Contract addContract() {
        String id = upIdContract();
        System.out.println("ID của bạn là: " + id);
        String idBooking = checkIdBooking();
        System.out.println("Nhập số tiền cọc trước");
        String deposit = scanner.nextLine();
        System.out.println("Nhập tổng tiền thanh toán");
        String price = scanner.nextLine();
        Contract contract = new Contract(id, idBooking, deposit, price);
        return contract;
    }

    public String checkIdBooking() {
        List<Booking> bookingList = bookingController.getList();
        displayBooking();
        String id;
        do {
            System.out.println("Nhập ID Booking");
            id = scanner.nextLine();
            for (Booking booking : bookingList) {
                if (booking.getId().equals(id)) {
                    return id;
                }
            }
            System.out.println("Không tìm thấy ID");
        } while (true);
    }

    public String checkIdContract() {
        System.out.println("Nhập ID hợp đồng cần sửa");
        List<Contract> contractList = contractController.getList();
        String id;
        do {
            id = scanner.nextLine();
            for (Contract contract : contractList) {
                if (contract.getId().equals(id)) {
                    return id;
                }
            }
            System.out.println("Không tìm thấy ID vui lòng nhập lại");
        } while (true);
    }

    public void editContract() {
        String id = checkIdContract();
        String idBooking = checkIdBooking();
        System.out.println("Nhập số tiền cọc");
        String deposit = scanner.nextLine();
        System.out.println("Nhập số tiền phải thanh toán");
        String price = scanner.nextLine();
        Contract contract = new Contract(id, idBooking, deposit, price);
        contractController.edit(id, contract);
    }

    public void displayContract() {
        List<Contract> contractList = contractController.getList();
        if (contractList.isEmpty()) {
            System.out.println("DS trống");
        } else {
            for (Contract contract : contractList) {
                System.out.println(contract);
            }
        }
    }

    public String upIdContract() {
        List<Contract> contractList = contractController.getList();
        String[] line;
        String text = null;
        for (Contract contract : contractList) {
            line = contract.getId().split("-");
            text = line[1];
        }
        return "CT-" + Integer.parseInt(text + 1);
    }

    public String upIdBooking() {
        List<Booking> bookings = bookingController.getList();
        String[] line;
        String text = null;
        for (Booking booking : bookings) {
            line = booking.getId().split("-");
            text = line[1];
        }
        return "BK-" + Integer.parseInt(text + 1);
    }


    public Booking addBooking() {
        String id = upIdBooking();
        System.out.println("ID booking của bạn là: " + id);
        String dateBooking = "03/11/2023";
        System.out.println("Ngày booking là ngày hôm nay : " + dateBooking);
        System.out.println("Nhập ngày bắt đầu ");
        String dateStart = checkDayLive();
        System.out.println("Nhập ngày kết thúc");
        String dateEnd = checkDayLive();
        System.out.println("Nhập ID customer");
        String idCustomer = checkIdCustomerLive();
        System.out.println("Nhập ID dịch vụ");
        String idService = checkIdServiceLive();
        Booking booking = new Booking(id, dateBooking, dateStart, dateEnd, idCustomer, idService);
        return booking;
    }


    public String checkIdServiceLive() {
        Map<Facility, Integer> facilityIntegerMap = facilityController.getList();
        String idService;
        if (facilityIntegerMap.isEmpty()) {
            System.out.println("DS trống");
        } else {
            System.out.println("DS ID service");
            for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
                System.out.println(map.getKey().getId());
            }
        }
        do {
            System.out.println("Nhập ID dịch vụ");
            idService = scanner.nextLine();
            for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
                if (map.getKey().getId().equals(idService)) {
                    return idService;
                }
            }
            System.out.println("ID không tồn tại vui lòng nhập lại");
        } while (true);
    }

    public String checkIdCustomerLive() {
        List<Customer> customerList = customerController.getList();
        String idCustomer;
        if (customerList.isEmpty()) {
            System.out.println("Ds trống ");
        } else {
            System.out.println("ID của customer");
            for (Customer customer : customerList) {
                System.out.println(customer.getId());
            }
        }
        do {
            System.out.println("Nhập ID của customer");
            idCustomer = scanner.nextLine();
            for (Customer customer : customerList) {
                if (customer.getId().equals(idCustomer)) {
                    return idCustomer;
                }
            }
            System.out.println("Vui lòng nhập lại ID không tồn tại");
        } while (true);
    }

    public void displayBooking() {
        List<Booking> bookings = bookingController.getList();
        if (bookings.isEmpty()) {
            System.out.println("DS trống");
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    public void displayListMaintenance() {
        Map<Facility, Integer> facilityIntegerMap = facilityController.displayListMaintenance();
        if (facilityIntegerMap.isEmpty()) {
            System.out.println("DS trống");
        } else {
            for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
                System.out.println(facilityIntegerEntry.getKey() + "" + facilityIntegerEntry.getValue());
            }
        }
    }

    public String removeFacility() {
        System.out.println("Nhập mã dịch vụ ");
        return checkEmpty();
    }

    public void showMenuAddFacility() {
        System.out.println("1. Thêm mới Villa");
        System.out.println("2. Thêm mới House");
        System.out.println("3. Thêm mới Room");
        System.out.println("4. Trở về menu");
    }

    public void displayMenuAddFacility() {
        int choice;
        do {
            try {
                showMenuAddFacility();
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        facilityController.add(addVilla());
                        break;
                    case 2:
                        facilityController.add(addHouse());
                        break;
                    case 3:
                        facilityController.add(addRoom());
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 -4");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public void displayFacility() {
        Map<Facility, Integer> facilityIntegerMap = facilityController.getList();
        if (facilityIntegerMap.isEmpty()) {
            System.out.println("DS trống");
        } else {
            for (Map.Entry<Facility, Integer> facilityEntry : facilityIntegerMap.entrySet()) {
                System.out.println(facilityEntry.getKey() + "" + facilityEntry.getValue());
            }
        }
    }

    public void displayFurama() {
        int choice;
        do {
            try {
                showFurama();
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayMenuEmployee();
                        break;
                    case 2:
                        displayMenuCustomer();
                        break;
                    case 3:
                        displayMenuFacility();
                        break;
                    case 4:
                        displayMenuBooking();
                    case 5:
                        System.exit(5);
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
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayEmployee();
                        break;
                    case 2:
                        employeeController.add(addEmployee());
                        break;
                    case 3:
                        choiceEditEmployee();
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

    public boolean checkDateValidate(String birthday) {
        LocalDate birthDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears() >= 0;
    }

    public boolean patternMatches(String check, String regex) {
        return Pattern.compile(regex).matcher(check).matches();
    }

    //Employee
    public String searchName() {
        System.out.println("Nhap ten can tim");
        return checkEmpty();
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

    public void choiceEditEmployee() {
        int choice;
        do {
            try {
                System.out.println("Chọn chức năng edit");
                System.out.println("1. Edit tất cả");
                System.out.println("2. Edit từng thứ");
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
            }
        } while (true);
    }

    public void editEmployeeV1() {
        int choice;
        String idEdit = checkIdEdit();
        List<Employee> employees = employeeController.getList();
        for (Employee employee : employees) {
            if (employee.getId().equals(idEdit)) {
                do {
                    try {
                        System.out.println("1. Edit tên: " + employee.getName());
                        System.out.println("2. Edit birthday: " + employee.getBirthday());
                        System.out.println("3. Edit giới tính: " + employee.getGender());
                        System.out.println("4. Edit CCCD: " + employee.getIdNumber());
                        System.out.println("5. Edit Sdt: " + employee.getPhone());
                        System.out.println("6. Edit Email: " + employee.getEmail());
                        System.out.println("7. Edit trình độ: " + employee.getLevel());
                        System.out.println("8. Edit vị trí làm việc: " + employee.getLocation());
                        System.out.println("9. Thoát edit");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                System.out.println("Nhập tên");
                                employee.setName(checkName());
                                break;
                            case 2:
                                System.out.println("Nhập birthday");
                                employee.setBirthday(checkBirthday());
                                break;
                            case 3:
                                System.out.println("Chọn giới tính");
                                employee.setGender(choiceGender());
                                break;
                            case 4:
                                System.out.println("Nhập CCCD");
                                employee.setIdNumber(idNumber());
                                break;
                            case 5:
                                System.out.println("Nhập SDT");
                                employee.setPhone(checkPhone());
                                break;
                            case 6:
                                System.out.println("Nhập Email");
                                employee.setEmail(checkEmail());
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
                    }
                } while (true);
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
        return new Employee(idEmployee, nameEmployee, birthdayEmployee, gender, idNumber, phone, email, level, location, wage);

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
            }
        } while (true);
    }

    public int idNumber() {
        String idNumberCheck;
        String regexNummber = "^[0-9]{9,12}$";
        do {
            idNumberCheck = checkEmpty();
            if (patternMatches(idNumberCheck, regexNummber)) {
                return Integer.parseInt(idNumberCheck);
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
                choice = Integer.parseInt(scanner.nextLine());
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
                return Integer.parseInt(phone);
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

    public String checkDayLive() {
        String day;
        do {
            try {
                day = checkEmpty();
                if (checkDateValidate(day)) {
                    return day;
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
        int choice;
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
                        choiceEditCustomer();
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

    public void choiceEditCustomer() {
        int choice;
        do {
            try {
                System.out.println("1. Sửa tất cả");
                System.out.println("2. Sửa chọn");
                System.out.println("3. Thoát");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        editCustomer();
                        break;
                    case 2:
                        editCustomerV2();
                        break;
                    case 3:
                        return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi ngoại lệ");
            }
        } while (true);
    }

    public void editCustomerV2() {
        List<Customer> customerList = customerController.getList();
        String id = checkIdEditCustomer();
        int choice;
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                do {
                    try {
                        System.out.println("1. Sửa tên: " + customer.getName());
                        System.out.println("2. Sửa birthday: " + customer.getBirthday());
                        System.out.println("3. Sửa giới tính: " + customer.getGender());
                        System.out.println("4. Sửa CCCD: " + customer.getIdNumber());
                        System.out.println("5. Sửa phone: " + customer.getPhone());
                        System.out.println("6. Sửa email: " + customer.getEmail());
                        System.out.println("7. Sửa loại khách hàng: " + customer.getType());
                        System.out.println("8. Sửa địa chỉ: " + customer.getAddress());
                        System.out.println("9. Thoát");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                System.out.println("Nhập tên");
                                customer.setName(checkName());
                                break;
                            case 2:
                                System.out.println("Nhập birthday");
                                customer.setBirthday(checkBirthday());
                                break;
                            case 3:
                                System.out.println("Chọn giới tính");
                                customer.setGender(choiceGender());
                                break;
                            case 4:
                                System.out.println("Nhập CCCD");
                                customer.setIdNumber(idNumber());
                                break;
                            case 5:
                                System.out.println("Nhập SDT");
                                customer.setPhone(checkPhone());
                                break;
                            case 6:
                                System.out.println("7. Nhập email");
                                customer.setEmail(checkEmail());
                                break;
                            case 7:
                                System.out.println("Chọn loại khách hàng");
                                customer.setType(choiceType());
                                break;
                            case 8:
                                System.out.println("Nhập địa chỉ khách hàng");
                                customer.setAddress(checkEmpty());
                                break;
                            case 9:
                                return;
                            default:
                                System.out.println("Vui lòng chọn từ 1 - 8");
                        }
                        customerController.edit(id, customer);
                    } catch (NumberFormatException e) {
                        System.out.println("Vui lòng nhập số");
                    }
                } while (true);
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
        }
        System.out.println("Bạn không xóa");
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
                choice = Integer.parseInt(scanner.nextLine());
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

    public String inputIdCustomer() {
        List<Customer> customerList = customerController.getList();
        int text = 1000;
        String[] str;
        for (Customer customer : customerList) {
            str = customer.getId().split("-");
            text = Integer.parseInt(str[1]);
        }
        return "KH-" + (text + 1);
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
                floor = Integer.parseInt(scanner.nextLine());
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
                choice = Integer.parseInt(scanner.nextLine());
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
                choice = Integer.parseInt(scanner.nextLine());
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
                people = Integer.parseInt(scanner.nextLine());
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
                price = Integer.parseInt(scanner.nextLine());
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
                area = Integer.parseInt(scanner.nextLine());
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
                choice = Integer.parseInt(scanner.nextLine());
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
        do {
            str = scanner.nextLine();
            if (!(str.isEmpty())) {
                return str;
            } else {
                System.out.println("Vui lòng nhập không để rỗng");
            }
        } while (true);
    }
}

