package Furama.views;

import Furama.controllers.BookingController;
import Furama.controllers.ContractController;
import Furama.controllers.CustomerController;
import Furama.controllers.FacilityController;
import Furama.models.Booking;
import Furama.models.Contract;
import Furama.models.facility.Facility;
import Furama.models.person.Customer;
import Furama.utils.Validate;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookingView {
    private final BookingController bookingController = new BookingController();
    private final ContractController contractController = new ContractController();
    private final CustomerController customerController = new CustomerController();
    private final FacilityController facilityController = new FacilityController();
    private final Validate validate = new Validate();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenuBooking() {
        System.out.println("1. Thêm mới booking");
        System.out.println("2. Hiển thị danh sách booking");
        System.out.println("3. Tạo mới hợp đồng");
        System.out.println("4. Hiển thị danh sách hợp đồng");
        System.out.println("5. Sửa hợp đồng ");
        System.out.println("6. Quay về");
    }

    public void displayMenuBooking() {
        int choice;
        do {
            try {
                showMenuBooking();
                System.out.println("Mời chọn");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        bookingController.add(addBooking());
                        break;
                    case 2:
                        displayBooking();
                        break;
                    case 3:
                        if (contractController.add(addContract())) {
                            System.out.println("Thêm thành công");
                        } else {
                            System.out.println("Thêm không thành công vui lòng thử lại");
                            return;
                        }
                        break;
                    case 4:
                        displayContract();
                        break;
                    case 5:
                        editContract();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 5 ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public void editContract() {
        String id = checkIdContract();
        String idBooking = checkIdBooking();
        System.out.println("Nhập số tiền cọc");
        String deposit = validate.checkEmpty();
        System.out.println("Nhập số tiền phải thanh toán");
        String price = validate.checkEmpty();
        Contract contract = new Contract(id, idBooking, deposit, price);
        contractController.edit(id, contract);
    }

    public String checkIdContract() {
        System.out.println("Nhập ID hợp đồng cần sửa");
        List<Contract> contractList = contractController.getList();
        String id;
        do {
            id = validate.checkEmpty();
            for (Contract contract : contractList) {
                if (contract.getId().equals(id)) {
                    return id;
                }
            }
            System.out.println("Không tìm thấy ID vui lòng nhập lại");
        } while (true);
    }

    public void displayContract() {
        List<Contract> contractList = contractController.getList();
        if (contractList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            System.out.println("Danh sách hợp đồng");
            for (Contract contract : contractList) {
                System.out.println(contract);
            }
        }
    }

    public String upIdBooking() {
        List<Booking> bookings = bookingController.getList();
        String[] line;
        int count = 0;
        for (Booking booking : bookings) {
            line = booking.getId().split("-");
            count = Integer.parseInt(line[1]);
        }
        if (count <= 9) {
            return "SVRO-000" + (count + 1);
        } else if (count <= 99) {
            return "BK-00" + (count + 1);
        } else if (count <= 999) {
            return "BK-0" + (count + 1);
        } else {
            return "BK-" + (count + 1);
        }
    }

    public boolean checkDateValidate(String birthday) {
        LocalDate birthDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears() >= 0;
    }

    public String checkDayLive() {
        String day;
        do {
            try {
                day = validate.checkEmpty();
                if (checkDateValidate(day)) {
                    return day;
                } else {
                    System.out.println("Vui lòng nhập lại");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Vui lòng nhập đúng định dạng ngày tháng năm dd/mm/yy");
            }
        } while (true);
    }

    public String dayNow() {
        return String.valueOf(LocalDate.now());
    }

    public Booking addBooking() {
        String id = upIdBooking();
        System.out.println("ID booking của bạn là: " + id);
        String dateBooking = dayNow();
        System.out.println("Ngày booking là ngày hôm nay : " + dateBooking);
        System.out.println("Nhập ngày bắt đầu ");
        String dateStart = checkDayLive();
        System.out.println("Nhập ngày kết thúc");
        String dateEnd = checkDayLive();
        System.out.println("Nhập ID customer");
        String idCustomer = checkIdCustomerLive();
        System.out.println("Nhập ID dịch vụ");
        String idService = checkIdServiceLive();
        Booking booking = new Booking(id, dateBooking, dateStart, dateEnd, idCustomer, idService);
        Map<Facility, Integer> facilityIntegerMap = facilityController.getList();
        for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
            if (map.getKey().getId().equals(idService)) {
                map.setValue(+1);
                facilityController.edit(idService, map.getKey());
            }
        }
        return booking;
    }


    public String checkIdServiceLive() {
        Map<Facility, Integer> facilityIntegerMap = facilityController.getList();
        List<Booking> bookingList = bookingController.getList();
        int count = 0;
        String idService;
        if (facilityIntegerMap.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            System.out.println("Danh sách dịch vụ");
            for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
                System.out.println(map.getKey());
            }
        }
        do {
            System.out.println("Nhập ID dịch vụ");
            idService = validate.checkEmpty();
            for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
                if (map.getKey().getId().equals(idService)) {
                    count = 1;
                    for (Booking booking : bookingList) {
                        if (booking.getIdService().equals(map.getKey().getId())) {
                            count = 2;
                            if (map.getValue() >= 5) {
                                count = 3;
                            }
                        }
                    }
                }
            }
            if (count == 1) {
                return idService;
            } else if (count == 2) {
                System.out.println("Dịch vụ đã có người sử dụng vui lòng chọn dịch vụ khác");
            } else if (count == 3) {
                System.out.println("Dịch vụ đang cần được bảo trì vui lòng chọn dịch vụ khác");
            } else {
                System.out.println("Không tìm thấy mã dịch vụ");
            }
        } while (true);
    }

    public String checkIdCustomerLive() {
        List<Customer> customerList = customerController.getList();
        String idCustomer;
        if (customerList.isEmpty()) {
            System.out.println("Danh sách khách hàng trống vui lòng thêm rồi thử lại ");
        } else {
            System.out.println("ID của customer");
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        }
        do {
            System.out.println("Nhập ID của customer");
            idCustomer = validate.checkEmpty();
            for (Customer customer : customerList) {
                if (customer.getId().equals(idCustomer)) {
                    return idCustomer;
                }
            }
            System.out.println("Vui lòng nhập lại ID không tồn tại");
        } while (true);
    }

    public String checkIdBooking() {
        List<Booking> bookingList = bookingController.getList();
        displayBooking();
        String id;
        do {
            System.out.println("Nhập ID Booking");
            id = validate.checkEmpty();
            for (Booking booking : bookingList) {
                if (booking.getId().equals(id)) {
                    return id;
                }
            }
            System.out.println("Không tìm thấy ID vui lòng nhập lại");
        } while (true);
    }

    public String upIdContract() {
        List<Contract> contractList = contractController.getList();
        String[] line;
        int count = 0;
        for (Contract contract : contractList) {
            line = contract.getId().split("-");
            count = Integer.parseInt(line[1]);
        }
        if (count <= 9) {
            return "CT-000" + (count + 1);
        } else if (count <= 99) {
            return "CT-00" + (count + 1);
        } else if (count <= 999) {
            return "CT-0" + (count + 1);
        } else {
            return "CT-" + (count + 1);
        }
    }

    public Contract addContract() {
        String id = upIdContract();
        System.out.println("ID của bạn là: " + id);
        String idBooking = checkIdBooking();
        System.out.println("Nhập số tiền cọc trước");
        String deposit = validate.checkEmpty();
        System.out.println("Nhập tổng tiền thanh toán");
        String price = validate.checkEmpty();
        return new Contract(id, idBooking, deposit, price);
    }

    public void displayBooking() {
        List<Booking> bookings = bookingController.getList();
        if (bookings.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            System.out.println("Danh sách booking");
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }
}
