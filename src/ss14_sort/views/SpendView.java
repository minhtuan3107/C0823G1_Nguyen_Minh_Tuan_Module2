package ss14_sort.views;

import ss14_sort.controllers.SpendController;
import ss14_sort.models.Spend;

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
                        outputSearchById();
                        break;
                    case 6:
                        outputSearchByName();
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

//    public int checkIdInput() {
//        int id;
//        List<Spend> spendList = spendController.getList();
//        int count = 0;
//        do {
//            id = Integer.parseInt(scanner.nextLine());
//            for (Spend spend : spendList) {
//                if (spend.getId() == id) {
//                    count++;
//                }
//            }
//            if (count == 0) {
//                return id;
//            } else {
//                System.out.println("Vui lòng nhập lại ID đã tồn tại");
//            }
//        } while (true);
//    }

    public int randomId() {
        List<Spend> spends = spendController.getList();
        int count = 0;
        for (Spend spend : spends) {
            count = spend.getId();
        }
        return count + 1;
    }

    public Spend add() {
        int id = randomId();
        System.out.println("ID của bạn là: " + id);
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
        System.out.println("Bạn có muốn sửa không y/n");
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
            System.out.println("Nhập ID cần xóa");
            id = Integer.parseInt(scanner.nextLine());
            for (Spend spend : spendList) {
                if (spend.getId() == id) {
                    System.out.println("Bạn có muốn xóa id " + id + " không ? y/n");
                    if (confirm()) {
                        return id;
                    } else {
                        System.out.println("Bạn không xóa");
                        break;
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

    public void outputSearchById() {
        List<Spend> spends = spendController.searchId(inputId());
        if (spends.isEmpty()) {
            System.out.println("Không tìm thấy ID");
        } else {
            for (Spend spend : spends) {
                System.out.println(spend);
            }
        }
    }

    public void outputSearchByName() {
        List<Spend> spends = spendController.searchName(inputName());
        if (spends.isEmpty()) {
            System.out.println("Không tìm thấy tên");
        } else {
            for (Spend spend : spends) {
                System.out.println(spend);
            }
        }
    }

    public String inputName() {
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        return name;
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
