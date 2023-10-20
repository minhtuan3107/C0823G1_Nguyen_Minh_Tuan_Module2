package ss13_search.view;

import ss13_search.controller.ISpendController;
import ss13_search.controller.SpendController;
import ss13_search.model.Spend;

import java.util.List;
import java.util.Scanner;

public class SpendView {
    private final ISpendController spendController = new SpendController();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("Quản lý chi tiêu");
        System.out.println("1.Hiển thị danh sách");
        System.out.println("2. Thêm");
        System.out.println("3. Xóa");
        System.out.println("4. Sửa");
        System.out.println("5. Tìm bằng ID");
        System.out.println("6. Tìm bằng tên");
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
                        spendController.remove(checkId());
                        break;
                    case 4:
                        edit();
                        break;
                    case 5:
                        spendController.searchId(inputId());
                        break;
                    case 6:
                        spendController.searchName(inputName());
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 7");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public int checkIdInput() {
        int id;
        do {
            id = Integer.parseInt(scanner.nextLine());
            List<Spend> spendList = spendController.getList();
            for (Spend spend : spendList) {
                if (spend.getId() == id) {
                    return id;
                }
            }
            System.out.println("ID không tồn tại vui lòng nhập lại");
        } while (true);
    }

    public Spend add() {
        System.out.println("Nhập ID mới");
        int id = checkIdInput();
        System.out.println("Nhập tên mới");
        String name = checkEmpty();
        System.out.println("Nhập ngày tháng");
        String date = checkEmpty();
        System.out.println("Nhập giá tiền");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mô tả");
        String des = checkEmpty();
        Spend spend = new Spend(id, name, date, price, des);
        return spend;
    }
    public String checkEmpty(){
        String check;
        do{
            check = scanner.nextLine();
            if(!(check.isEmpty())){
                return check;
            }else {
                System.out.println("Vui lòng nhập không được để trống");
            }
        }while (true);
    }

    public void edit() {
        int id = checkId();
        System.out.println("Nhập tên muốn sửa");
        String name = checkEmpty();
        System.out.println("Nhập ngày muốn sửa");
        String date = checkEmpty();
        System.out.println("Nhập số tiền muốn sửa");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mô tả");
        String des = checkEmpty();
        System.out.println("Bạn có muốn sửa y/n");
        confirm();
        if (confirm()) {
            Spend spend = new Spend(id, name, date, price, des);
            spendController.edit(id, spend);
        } else {
            System.out.println("Bạn không sửa");
        }
    }

    public boolean confirm() {
        String check = checkEmpty();
        if (check.toLowerCase().equals("y")) {
            return true;
        }
        return false;
    }

    public int checkId() {
        int id;
        do {
            try {
                System.out.println("Nhập ID");
                id = Integer.parseInt(scanner.nextLine());
                List<Spend> spendList = spendController.getList();
                for (Spend spend : spendList) {
                    if (spend.getId() == id) {
                        return id;
                    }
                }
                System.out.println("ID không tồn tại vui lòng nhập lại");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public int inputId() {
        System.out.println("Nhập ID");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public String inputName() {
        System.out.println("Nhập tên");
        String name = checkEmpty();
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
