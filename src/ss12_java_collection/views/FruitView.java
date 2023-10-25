package ss12_java_collection.views;

import ss12_java_collection.controllers.FruitController;
import ss12_java_collection.controllers.IFruitController;
import ss12_java_collection.models.Fruit;

import java.util.Map;
import java.util.Scanner;

public class FruitView {
    private final IFruitController fruitController = new FruitController();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("Quản lý trái cây");
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
                        display();
                        break;
                    case 2:
                        fruitController.add(add());
                        break;
                    case 3:
                        fruitController.remove(inputId());
                        break;
                    case 4:
                        edit();
                        break;
                    default:
                        System.out.println("Vui lòng nhập từ 1 -4");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }


    public Fruit add() {
        System.out.println("Nhập ID trái cây");
        int id = checkIdInput();
        System.out.println("Nhập tên trái cây");
        String name = scanner.nextLine();
        System.out.println("Nhập loại trai cây");
        String type = scanner.nextLine();
        System.out.println("Nhập ngày sản xuất");
        String date = scanner.nextLine();
        System.out.println("Nhập hạn sản sử dụng");
        String exp = scanner.nextLine();
        System.out.println("Nhập nơi sản xuất");
        String origin = scanner.nextLine();
        System.out.println("Nhập giá tiền");
        int price = Integer.parseInt(scanner.nextLine());
        Fruit fruit = new Fruit(id, name, type, date, exp, origin, price);
        return fruit;
    }

    public void display() {
        Map<Integer, Fruit> fruitMap = fruitController.getList();
        if (fruitMap.isEmpty()) {
            System.out.println("DS trống");
        } else {
            for (Map.Entry<Integer, Fruit> fruitEntry : fruitMap.entrySet()) {
                System.out.println(fruitEntry.getKey() + " " + fruitEntry.getValue());
            }
        }
    }


    public Integer inputId() {
        System.out.println("Nhập ID");
        Integer id;
        Map<Integer, Fruit> fruitMap = fruitController.getList();
        do {
            id = Integer.parseInt(scanner.nextLine());
            for (Map.Entry<Integer, Fruit> fruitEntry : fruitMap.entrySet()) {
                if (fruitEntry.getValue().getIdFruit() == id) {
                    return id;
                }
                System.out.println("ID không tồn tại vui lòng nhập lại");
            }
        } while (true);
    }

    public Integer checkIdInput() {
        Integer id;
        int count;
        Map<Integer, Fruit> fruitMap = fruitController.getList();
        do {
            count = 0;
            id = Integer.parseInt(scanner.nextLine());
            for (Map.Entry<Integer, Fruit> fruitEntry : fruitMap.entrySet()) {
                if (fruitEntry.getValue().getIdFruit() == id) {
                    count++;
                }
            }
            if (count == 0) {
                return id;
            }
            System.out.println("Vui lòng nhập lại ID đã tồn tại");
        } while (true);
    }

    public void edit() {
        System.out.println("Nhập ID cần sửa");
        int idEdit = inputId();
        System.out.println("Nhập tên trái cây mới");
        String name = scanner.nextLine();
        System.out.println("Nhập loại trai cây mới");
        String type = scanner.nextLine();
        System.out.println("Nhập ngày sản xuất mới");
        String date = scanner.nextLine();
        System.out.println("Nhập hạn sản sử dụng mới");
        String exp = scanner.nextLine();
        System.out.println("Nhập nơi sản xuất mới");
        String origin = scanner.nextLine();
        System.out.println("Nhập giá tiền mới");
        int price = Integer.parseInt(scanner.nextLine());
        Fruit fruit = new Fruit(idEdit, name, type, date, exp, origin, price);
        fruitController.edit(idEdit, fruit);
    }
}
