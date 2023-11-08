package Furama.views;

import Furama.controllers.CustomerController;
import Furama.models.Customer;
import Furama.utils.Validate;

import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private final CustomerController customerController = new CustomerController();
    private final Scanner scanner = new Scanner(System.in);
    private final Validate validate = new Validate();

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
                        System.out.println("Nhập ID cần xóa");
                        String id = checkIdCustomerLive();
                        System.out.println("Bạn có muốn xóa không? y/n");
                        if (checkStatus()) {
                            System.out.println("Xóa thành công");
                            customerController.delete(id);
                        } else {
                            System.out.println("Bạn không xóa");
                            return;
                        }
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
        System.out.println("Nhập ID cần sửa");
        String id = checkIdCustomerLive();
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
                                customer.setName(validate.checkName());
                                break;
                            case 2:
                                System.out.println("Nhập birthday");
                                customer.setBirthday(validate.checkBirthday());
                                break;
                            case 3:
                                System.out.println("Chọn giới tính");
                                customer.setGender(validate.choiceGender());
                                break;
                            case 4:
                                System.out.println("Nhập CCCD");
                                customer.setIdNumber(validate.idNumber());
                                break;
                            case 5:
                                System.out.println("Nhập SDT");
                                customer.setPhone(validate.checkPhone());
                                break;
                            case 6:
                                System.out.println("7. Nhập email");
                                customer.setEmail(validate.checkEmail());
                                break;
                            case 7:
                                System.out.println("Chọn loại khách hàng");
                                customer.setType(choiceTypeCustomer());
                                break;
                            case 8:
                                System.out.println("Nhập địa chỉ khách hàng");
                                customer.setAddress(validate.checkEmpty());
                                break;
                            case 9:
                                return;
                            default:
                                System.out.println("Vui lòng chọn từ 1 - 8");
                        }
                        customerController.edit(id, customer);
                    } catch (NumberFormatException e) {
                        System.out.println("Vui lòng nhập số");
                    } catch (Exception e) {
                        System.out.println("Lỗi ngoại lệ không xác định");
                    }
                    customerController.edit(id, customer);
                } while (true);
            }
            customerController.edit(id, customer);
        }
    }

    public void editCustomer() {
        System.out.println("Nhập ID cần sửa");
        String id = checkIdCustomerLive();
        System.out.println("Nhập tên cần sửa");
        String name = validate.checkName();
        System.out.println("Nhập Birthday cần sửa");
        String birthday = validate.checkBirthday();
        System.out.println("Chọn giới tính");
        String gender = validate.choiceGender();
        System.out.println("Nhập CCCD");
        int idNumber = validate.idNumber();
        System.out.println("Nhập SDT");
        int phone = validate.checkPhone();
        System.out.println("Nhập email");
        String email = validate.checkEmail();
        System.out.println("Chọn loại khách hàng");
        String type = choiceTypeCustomer();
        System.out.println("Nhập địa chỉ");
        String address = validate.checkEmpty();
        System.out.println("Bạn có muốn sửa không y/n ");
        if (!checkStatus()) {
            System.out.println("Sửa thành công");
            Customer customer = new Customer(id, name, birthday, gender, idNumber, phone, email, type, address);
            customerController.edit(id, customer);
        } else {
            System.out.println("Bạn không sửa");
        }
    }

    public boolean checkStatus() {
        String check = scanner.nextLine();
        if (check.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    public String checkIdCustomerLive() {
        String id;
        do {
            id = validate.checkEmpty();
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
        System.out.println("Nhập họ và tên khách hàng vd:Nguyen Minh Tuan");
        String name = validate.checkName();
        System.out.println("Nhập birthday khách hàng dd/mm/yy");
        String birthday = validate.checkBirthday();
        System.out.println("Chọn giới tính");
        String gender = validate.choiceGender();
        System.out.println("Nhập số CCCD 9 - 12 số");
        int idNumber = validate.idNumber();
        System.out.println("Nhập SDT");
        int phone = validate.checkPhone();
        System.out.println("Nhập Email");
        String email = validate.checkEmail();
        System.out.println("Chọn loại khách hàng");
        String type = choiceTypeCustomer();
        System.out.println("Nhập địa chỉ");
        String address = validate.checkEmpty();
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
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
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

    public String searchName() {
        System.out.println("Nhap ten can tim");
        return validate.checkEmpty();
    }
}
