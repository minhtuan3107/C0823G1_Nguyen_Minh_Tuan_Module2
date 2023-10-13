package ss12_javacollection_framework.view;

import ss12_javacollection_framework.controller.FruitController;
import ss12_javacollection_framework.controller.IFruitController;
import ss12_javacollection_framework.model.Fruit;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FruitView {
    IFruitController fruitController = new FruitController();
    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("1. Hiển thị danh sách trái cây");
        System.out.println("2. Thêm");
        System.out.println("3. Xóa");
        System.out.println("4. Sửa");
    }

    public void runMenu() {
        int choice;
        do {
            try {
                showMenu();
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        display(fruitController.getList());
                        break;
                    case 2:
                        fruitController.add(add());
                        break;
                    case 3:
                        fruitController.remove(inputPrice());
                        break;
                    case 4:
                        fruitController.edit(inputPrice(), add());
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

    public Fruit add() {
        System.out.println("Nhập tên trái cây");
        String name = scanner.nextLine();
        System.out.println("Nhập loại trái cây");
        String type = scanner.nextLine();
        System.out.println("Nhập ngày sản xuất");
        String date = scanner.nextLine();
        System.out.println("Nhập hạn sử dụng");
        String expiry = scanner.nextLine();
        System.out.println("Nhập xuất xứ");
        String origin = scanner.nextLine();
        System.out.println("Nhập giá");
        int price = Integer.parseInt(scanner.nextLine());
        return new Fruit(name, type, date, expiry, origin, price);
    }

    public void display(HashMap<Integer, Fruit> fruitHashMap) {
        if (fruitHashMap.size() == 0) {
            System.out.println("Danh sách trống");
        } else {
            for (Map.Entry<Integer, Fruit> value : fruitHashMap.entrySet()) {
                System.out.println("key = " + value.getKey() +
                        "value = " + value.getValue());
            }
        }
    }

    public Integer inputPrice() {
        System.out.println("Nhập giá tiền trái cây muốn xóa/sửa");
        Integer price = Integer.parseInt(scanner.nextLine());
        return price;
    }
}
