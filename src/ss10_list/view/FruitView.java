package ss10_list.view;

import ss10_list.controller.FruitController;
import ss10_list.controller.IFruitController;
import ss10_list.model.Fruit;

import java.util.List;
import java.util.Scanner;

public class FruitView {
    private final Scanner scanner = new Scanner(System.in);
    private final IFruitController fruitController = new FruitController();

    public void displayMenu() {
        int choice;
        do {
            try {
                showMenu();
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        fruitController.add(add());
                        break;
                    case 2:
                        display(fruitController.getList());
                        break;
                    case 3:
                        fruitController.delete(inputName());
                        break;
                    case 4:
                        editFruit();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Nhập từ 1 -5");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public void showMenu() {
        System.out.println("== Quản lý trái cây ==");
        System.out.println("1. Thêm");
        System.out.println("2. Hiển thị");
        System.out.println("3. Xóa");
        System.out.println("4. Sửa");
        System.out.println("4. Thoát");
    }

    public String checkNameEdit() {
        String id;
        do {
            id = scanner.nextLine();
            List<Fruit> fruitList = fruitController.getList();
            for (Fruit fruit : fruitList) {
                if (fruit.getNameFruit().equals(id)) {
                    return id;
                }
            }
            System.out.println("ID khong ton tai vui long nhap lai");
        } while (true);
    }


    public void editFruit() {
        System.out.println("Nhập tên trái cây muốn sửa");
        String name = checkNameEdit();
        System.out.println("Nhập loại trái cây");
        String type = checkEmpty();
        System.out.println("Nhập ngày sản xuất");
        String date = scanner.nextLine();
        System.out.println("Nhập hạn sử dụng");
        String expiry = scanner.nextLine();
        System.out.println("Nhập xuất sứ");
        String origin = scanner.nextLine();
        System.out.println("Nhập giá tiền");
        String price = scanner.nextLine();
        System.out.println("Bạn có muốn sửa không ? y/n");
        if (confirm()) {
            System.out.println("Sửa thành công");
            Fruit fruit = new Fruit(name, type, date, expiry, origin, price);
            fruitController.edit(name, fruit);
        } else {
            System.out.println("Bạn không sửa");
        }
    }

    public String checkEmpty() {
        String check;
        do {
            check = scanner.nextLine();
            if (!(check.isEmpty())) {
                return check;
            } else {
                System.out.println("Vui lòng nhập không được để rỗng");
            }
        } while (true);
    }

    public boolean confirm() {
        String confirm = scanner.nextLine();
        do {
            if (confirm.equalsIgnoreCase("y")) {
                return true;
            }
            return false;
        } while (true);
    }

    public String inputName() {
        List<Fruit> fruitList = fruitController.getList();
        do {
            System.out.println("Nhập tên cần xóa");
            String name = scanner.nextLine();
            for (Fruit fruit : fruitList) {
                if (fruit.getNameFruit().equals(name)) {
                    System.out.println("Bạn có muốn xóa không y/n");
                    if (confirm()) {
                        System.out.println("Xóa thành công");
                        return name;
                    } else {
                        System.out.println("Bạn không xóa");
                    }
                }
            }
            System.out.println("Tên không tồn tại vui lòng nhập lại");
        } while (true);
    }


    public Fruit add() {
        System.out.println("Nhập tên trái cây");
        String nameFruit = checkEmpty();
        System.out.println("Nhập loại trái cây");
        String typeFruit = checkEmpty();
        System.out.println("Nhập ngày sản xuất");
        String date = checkEmpty();
        System.out.println("Nhập hạn sử dụng");
        String exp = checkEmpty();
        System.out.println("Nhập xuất xứ");
        String origin = checkEmpty();
        System.out.println("Nhập giá tiền");
        String price = checkEmpty();
        Fruit fruit = new Fruit(nameFruit, typeFruit, date, exp, origin, price);
        return fruit;
    }

    public void display(List<Fruit> fruitList) {
        if (fruitList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (Fruit fruit : fruitList) {
                System.out.println(fruit);
            }
        }
    }
}
