package ss10_list.view;

import ss10_list.controller.FruitController;
import ss10_list.controller.IFruitController;
import ss10_list.model.Fruit;

import java.util.List;
import java.util.Scanner;

public class FruitView {
    private Scanner scanner = new Scanner(System.in);
    private IFruitController fruitController = new FruitController();

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
                        return;
                    default:
                        System.out.println("Nhập từ 1 -4");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public void showMenu() {
        System.out.println("1. Thêm");
        System.out.println("2. Hiển thị");
        System.out.println("3. Xóa");
        System.out.println("4. Thoát");
    }

    public boolean checkStatus() {

        return false;
    }

    public String inputName() {
        List<Fruit> fruitList = fruitController.getList();
        do {
            System.out.println("Nhập tên cần sửa/ xóa");
            String name = scanner.nextLine();
            for (Fruit fruit : fruitList) {
                if (fruit.getNameFruit().equals(name)) {
                    System.out.println("Bạn có muốn xóa không y/n");
                    String check = scanner.nextLine();
                    if (check.toLowerCase().equals("y")) {
                        return name;
                    }
                } else {
                    System.out.println("Tên không tồn tại vui lòng nhập lại");
                }
            }
        } while (true);
    }

    public Fruit add() {
        System.out.println("Nhập tên");
        String nameFruit = scanner.nextLine();
        System.out.println("Nhập loại trái cây");
        String typeFruit = scanner.nextLine();
        System.out.println("Nhập ngày sản xuất");
        String date = scanner.nextLine();
        System.out.println("Nhập hạn sử dụng");
        String exp = scanner.nextLine();
        System.out.println("Nhập xuất xứ");
        String origin = scanner.nextLine();
        System.out.println("Nhập giá tiền");
        String price = scanner.nextLine();
        Fruit fruit = new Fruit(nameFruit, typeFruit, date, exp, origin, price);
        return fruit;
    }

    public void display(List<Fruit> fruitList) {
        if (fruitList.size() == 0) {
            System.out.println("Danh sách trống");
        } else {
            for (Fruit fruit : fruitList) {
                System.out.println(fruit);
            }
        }
    }
}
