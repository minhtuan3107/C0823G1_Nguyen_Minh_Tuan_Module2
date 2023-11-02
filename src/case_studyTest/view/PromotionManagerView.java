package case_studyTest.view;

import java.util.Scanner;

public class PromotionManagerView {
    private final Scanner scanner = new Scanner(System.in);
    public void displayPromotionMenu() {
        System.out.println("1. Hiển thị danh sách khách hàng sử dụng dịch vụ");
        System.out.println("2. Hiển thị danh sách khách hàng sử dụng khuyến mãi");
        System.out.println("3. Return main menu");
    }
    public int inputOption(){
        int option =0;
        do {
            try {
                System.out.println("Chọn chức năng :");
                option = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Vui lòng nhập số");
            }
        } while (option <= 0 || option > 3);
        return option;
    }
    public void handlePromotionManagementOption(int option) {
        switch (option) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                return;
        }
    }
    public void menuPromotion(){
        int temp;
        do{
            displayPromotionMenu();
            temp = inputOption();
            handlePromotionManagementOption(temp);
        }while (temp!=3);
    }
}
