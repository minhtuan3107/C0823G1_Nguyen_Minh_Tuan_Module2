package Furama.views;

import java.util.Scanner;

public class FuramaView {
    private final Scanner scanner = new Scanner(System.in);
    private final FacilityView facilityView = new FacilityView();
    private final CustomerView customerView = new CustomerView();
    private final EmployeeView employeeView = new EmployeeView();
    private final BookingView bookingView = new BookingView();

    public void showFurama() {
        System.out.println("= FURAMA =");
        System.out.println("1. Quản lý nhân viên");
        System.out.println("2. Quản lý khách hàng");
        System.out.println("3. Quản lý cơ sở vật chất");
        System.out.println("4. Quản lý booking");
        System.out.println("5. Thoát");
        System.out.println("Mời chọn");
    }

    public void displayFurama() {
        int choice;
        do {
            try {
                showFurama();
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        employeeView.displayMenuEmployee();
                        break;
                    case 2:
                        customerView.displayMenuCustomer();
                        break;
                    case 3:
                        facilityView.displayMenuFacility();
                        break;
                    case 4:
                        bookingView.displayMenuBooking();
                    case 5:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }
}
