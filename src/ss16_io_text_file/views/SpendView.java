package ss16_io_text_file.views;

import ss16_io_text_file.controllers.SpendController;
import ss16_io_text_file.models.Spend;

import java.util.List;
import java.util.Scanner;

public class SpendView {
    private final SpendController spendController = new SpendController();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("Quản lý chi tiêu");
        System.out.println("1.Hiển thị danh sách");
        System.out.println("2. Thêm");
        System.out.println("3. Xóa");
        System.out.println("4. Sửa");
        System.out.println("5. Tìm bằng ID");
        System.out.println("6. Tìm bằng tên");
        System.out.println("7. Sắp xếp bằng tên");
        System.out.println("8. Sắp xếp số tiền");
        System.out.println("9. Thoát");
    }

    public void runMenu() {
        int choice;
        do {
            showMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        display();
                        break;
                    case 2:
                        spendController.add(add());
                        break;
                    case 3:
                        spendController.remove(checkIdRemove());
                        break;
                    case 4:
                        edit();
                        break;
                    case 5:
                        outputSearchId();
                        break;
                    case 6:
                        outputSearchName();
                        break;
                    case 7:
                        spendController.sortName();
                        display();
                        break;
                    case 8:
                        spendController.sortPrice();
                        display();
                        break;
                    case 9:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 9");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public int checkIdInput() {
        int id;
        List<Spend> spendList = spendController.getList();
        do {
            id = Integer.parseInt(scanner.nextLine());
            int count = 0;
            for (Spend spend : spendList) {
                if (spend.getId() == id) {
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

    public Spend add() {
        System.out.println("Nhập ID mới");
        int id = checkIdInput();
        System.out.println("Nhập tên mới");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày tháng");
        String date = scanner.nextLine();
        System.out.println("Nhập giá tiền");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mô tả");
        String des = scanner.nextLine();
        Spend spend = new Spend(id, name, date, price, des);
        return spend;
    }

    public void edit() {
        int id = checkId();
        System.out.println("Nhập tên muốn sửa");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày muốn sửa");
        String date = scanner.nextLine();
        System.out.println("Nhập số tiền muốn sửa");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mô tả");
        String des = scanner.nextLine();
        System.out.println("Bạn có muốn sửa y/n");
        if (confirm()) {
            Spend spend = new Spend(id, name, date, price, des);
            spendController.edit(id, spend);
        } else {
            System.out.println("Bạn không sửa");
        }
    }

    public boolean confirm() {
        String check = scanner.nextLine();
        if (check.toLowerCase().equals("y")) {
            return true;
        }
        return false;
    }

    public int checkId() {
        List<Spend> spendList = spendController.getList();
        int id;
        do {
            System.out.println("Nhập ID");
            id = Integer.parseInt(scanner.nextLine());
            for (Spend spend : spendList) {
                if (spend.getId() == id) {
                    return id;
                }
            }
            System.out.println("ID không tồn tại vui lòng nhập lại");
        } while (true);
    }

    public int checkIdRemove() {
        List<Spend> spendList = spendController.getList();
        int id;
        do {
            System.out.println("Nhập ID");
            id = Integer.parseInt(scanner.nextLine());
            for (Spend spend : spendList) {
                if (spend.getId() == id) {
                    System.out.println("Bạn có muốn xóa không? y/n");
                    if (confirm()) {
                        return id;
                    } else {
                        System.out.println("Bạn không xóa");
                    }
                }
            }
            System.out.println("ID không tồn tại vui lòng nhập lại");
        } while (true);
    }

    public int inputId() {
        System.out.println("Nhập ID");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public String inputName() {
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        return name;
    }

    public void outputSearchName() {
        List<Spend> spendList = spendController.searchName(inputName());
        if (spendList.isEmpty()) {
            System.out.println("Không tìm thấy tên");
        } else {
            for (Spend spend : spendList) {
                System.out.println(spend);
            }
        }
    }

    public void outputSearchId() {
        List<Spend> spendList = spendController.searchId(inputId());
        if (spendList.isEmpty()) {
            System.out.println("Không tìm thấy ID");
        } else {
            for (Spend spend : spendList) {
                System.out.println(spend);
            }
        }
    }

    public void display() {
        List<Spend> spendList = spendController.getList();
        if (spendList.size() == 0) {
            System.out.println("Danh sách trống");
        } else {
            for (Spend spend : spendList) {
                System.out.println(spend);
            }
        }
    }
}
