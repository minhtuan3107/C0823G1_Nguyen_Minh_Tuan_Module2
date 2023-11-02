package case_studyTest.view;

import java.util.Scanner;

public class FuramaManagerView {
    Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        System.out.println("====Menu====");
        System.out.println("1. Quản lý nhân viên");
        System.out.println("2. Quản lý khách hàng");
        System.out.println("3. Quản lý Facility");
        System.out.println("4. Quản lý Booking");
        System.out.println("5. Quản lý Promotion");
        System.out.println("6. Thoát");
    }

    public int inputOption() {
        int option = 0;
        do {
            try {
                System.out.println("Mời chọn");
                option = Integer.parseInt(scanner.nextLine());
                if (option > 6 || option <= 0) {
                    System.out.println("Vui lòng chọn từ  1 - 6");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (option <= 0 || option > 6);
        return option;
    }

    public void furamaManagement(int option) {
        switch (option) {
            case 1:
                EmployeeManagerView employeeManagerView = new EmployeeManagerView();
                employeeManagerView.employeeMenu();
                break;
            case 2:
                CustomerManagerView customerManagerView = new CustomerManagerView();
                customerManagerView.customerMenu();
                break;
            case 3:
                FacilityManagerView facilityManagerView = new FacilityManagerView();
                facilityManagerView.facilityMenu();
                break;
            case 4:
                BookingManagerView bookingManagerView = new BookingManagerView();
                bookingManagerView.menuBooking();
                break;
            case 5:
                PromotionManagerView promotionManagerView = new PromotionManagerView();
                promotionManagerView.menuPromotion();
                break;
            case 6:
                System.exit(1);
        }
    }

    public void runMenuFurama() {
        while (true) {
            displayMainMenu();
            furamaManagement(inputOption());
        }
    }
}
