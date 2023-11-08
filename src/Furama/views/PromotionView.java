package Furama.views;

import Furama.controllers.PromotionController;
import Furama.models.person.Customer;
import Furama.models.Promotion;

import java.util.List;
import java.util.Scanner;

public class PromotionView {
    private final Scanner scanner = new Scanner(System.in);

    private final PromotionController promotionController = new PromotionController();

    public void showMenuPromotion() {
        System.out.println("1. Hiển thị danh sách khách hàng sử dụng dịch vụ");
        System.out.println("2. Hiển thị danh sách khách hàng có khuyến mãi");
        System.out.println("3. Trở về menu");
        System.out.println("Mời chọn");
    }

    public void displayMenuPromotion() {
        int choice;
        do {
            try {
                showMenuPromotion();
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayListCustomerUseService();
                        break;
                    case 2:
                        displayListCustomerGetVoucher();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public void displayListCustomerUseService() {
        List<Customer> customerList = promotionController.displayCustomerUserService();
        if (customerList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            System.out.println("Danh sách khách hàng đang sử dụng dịch vụ");
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        }
    }

    public Promotion addVoucher() {
        System.out.println("Nhập số lượng voucher");
        int count = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập voucher");
        String voucher = scanner.nextLine();
        Promotion promotion = new Promotion(count, voucher);
        return promotion;
    }

    public void displayListCustomerGetVoucher() {
        List<Customer> customerList = promotionController.displayCustomerGetVoucher(addVoucher());
        if (customerList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            System.out.println("Danh sách khách hàng đang được tặng voucher");
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        }
    }
}
