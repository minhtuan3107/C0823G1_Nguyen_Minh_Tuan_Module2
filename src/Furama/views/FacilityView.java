package Furama.views;

import Furama.controllers.FacilityController;
import Furama.models.Facility;
import Furama.models.House;
import Furama.models.Room;
import Furama.models.Villa;
import Furama.utils.Validate;

import java.util.Map;
import java.util.Scanner;

public class FacilityView {
    private final FacilityController facilityController = new FacilityController();
    private final Validate validate = new Validate();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenuFacility() {
        System.out.println("1. Hiển thị list Facility");
        System.out.println("2. Thêm mới Facility");
        System.out.println("3. Hiển thị danh sách Facility cần bảo trì");
        System.out.println("4. Xóa facility");
        System.out.println("5. Quay về");
    }

    public void displayMenuFacility() {
        int choice;
        do {
            try {
                showMenuFacility();
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayFacility();
                        break;
                    case 2:
                        displayMenuAddFacility();
                        break;
                    case 3:
                        displayListMaintenance();
                        break;
                    case 4:
                        facilityController.delete(checkIdLive());
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Vui lòng chọn 1 - 5");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        } while (true);
    }

    public void showMenuAddFacility() {
        System.out.println("1. Thêm mới Villa");
        System.out.println("2. Thêm mới House");
        System.out.println("3. Thêm mới Room");
        System.out.println("4. Trở về menu");
    }

    public void displayMenuAddFacility() {
        int choice;
        do {
            try {
                showMenuAddFacility();
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        facilityController.add(addVilla());
                        break;
                    case 2:
                        facilityController.add(addHouse());
                        break;
                    case 3:
                        facilityController.add(addRoom());
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 -4");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        } while (true);
    }

    public String inputIdRoom() {
        Map<Facility, Integer> facilityIntegerEntry = facilityController.getList();
        int count = 0;
        String[] str;
        for (Map.Entry<Facility, Integer> map : facilityIntegerEntry.entrySet()) {
            str = map.getKey().getId().split("-");
            count = Integer.parseInt(str[1]);
        }
        if (count <= 9) {
            return "SVRO-000" + (count + 1);
        } else if (count <= 99) {
            return "SVRO-00" + (count + 1);
        } else if (count <= 999) {
            return "SVRO-0" + (count + 1);
        } else {
            return "SVRO-" + (count + 1);
        }
    }


    public Room addRoom() {
        String roomId = inputIdRoom();
        System.out.println("ID dịch vụ room là : " + roomId);
        System.out.println("Nhập tên dịch vụ");
        String name = nameServiceCheck();
        System.out.println("Nhập diện tích sử dụng trên 30");
        int area = areaCheck();
        System.out.println("Nhập chi phí thuê ");
        int price = checkPrice();
        System.out.println("Nhập số lượng người ở dưới 20 người ");
        int people = checkPeople();
        System.out.println("Chọn kiểu thuê");
        String type = choiceType();
        System.out.println("Chọn dịch vụ miễn phí");
        String serviceFree = choiceServiceFree();
        return new Room(roomId, name, area, price, people, type, serviceFree);
    }

    public String choiceServiceFree() {
        int choice;
        do {
            try {
                System.out.println("1.Nuoc uong mien phi");
                System.out.println("2.Phuong tien di lai mien phi");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return "Nuoc uong mien phi";
                    case 2:
                        return "Phuong tien di lai mien phi";
                    default:
                        System.out.println("Nhập 1 - 2");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        } while (true);
    }

    public String choiceType() {
        int choice;
        do {
            try {
                System.out.println("1. Thuê theo năm");
                System.out.println("2. Thuê theo tháng");
                System.out.println("3. Thuê theo ngày");
                System.out.println("4. Thuê theo giờ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return "thuê theo năm";
                    case 2:
                        return "thuê theo tháng";
                    case 3:
                        return "thuê theo ngày";
                    case 4:
                        return "thuê theo giờ";
                    default:
                        System.out.println("Nhập từ 1 - 4");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        } while (true);
    }

    public int checkPeople() {
        int people;
        do {
            try {
                people = Integer.parseInt(scanner.nextLine());
                if (people > 1 && people <= 20) {
                    return people;
                } else {
                    System.out.println("Vui lòng nhập lớn hơn 0 và bé hơn 20");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        } while (true);
    }

    public int checkPrice() {
        int price;
        do {
            try {
                price = Integer.parseInt(scanner.nextLine());
                if (price > 1) {
                    return price;
                } else {
                    System.out.println("Vui lòng nhập số dương");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        } while (true);
    }

    public int areaCheck() {
        int area;
        do {
            try {
                area = Integer.parseInt(scanner.nextLine());
                if (area >= 30) {
                    return area;
                } else {
                    System.out.println("Vui lòng nhập diện tích lớn hơn 30");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        } while (true);
    }

    public String nameServiceCheck() {
        String nameCheck;
        String regexId = "^([A-Z])[a-z ]+$";
        do {
            nameCheck = validate.checkEmpty();
            if (validate.patternMatches(nameCheck, regexId)) {
                return nameCheck;
            } else {
                System.out.println("Vui lòng nhập đúng định dạng viết hoa kí tự đầu ");
            }
        } while (true);
    }

    public House addHouse() {
        String idHouse = inputIdHouse();
        System.out.println("Mã dịch vụ của House là: " + idHouse);
        System.out.println("Nhập tên dịch vụ House");
        String name = nameServiceCheck();
        System.out.println("Nhập diện tích sử dụng");
        int area = areaCheck();
        System.out.println("Nhập chi phí thuê");
        int price = checkPrice();
        System.out.println("Nhập số lượng người");
        int people = checkPeople();
        System.out.println("Chọn kiểu thuê");
        String type = choiceType();
        System.out.println("Chọn tiêu chuẩn phòng");
        String standard = choiceStandard();
        System.out.println("Nhập số tầng");
        int floor = checkFloor();
        return new House(idHouse, name, area, price, people, type, standard, floor);
    }

    public int checkFloor() {
        int floor;
        do {
            try {
                floor = Integer.parseInt(scanner.nextLine());
                if (floor >= 1) {
                    return floor;
                } else {
                    System.out.println("Vui lòng nhập số lớn hơn 1");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        } while (true);
    }

    public String choiceStandard() {
        int choice;
        do {
            try {
                System.out.println("1. *");
                System.out.println("2. **");
                System.out.println("3. ***");
                System.out.println("4. ****");
                System.out.println("5. *****");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return "1 sao";
                    case 2:
                        return "2 sao";
                    case 3:
                        return "3 sao";
                    case 4:
                        return "4 sao";
                    case 5:
                        return "5 sao";
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 5");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        } while (true);
    }

    public String inputIdHouse() {
        Map<Facility, Integer> facilityIntegerMap = facilityController.getList();
        String[] str;
        int count = 0;
        for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
            str = map.getKey().getId().split("-");
            count = Integer.parseInt(str[1]);
        }
        if (count <= 9) {
            return "SVHO-000" + (count + 1);
        } else if (count <= 99) {
            return "SVHO-00" + (count + 1);
        } else if (count <= 999) {
            return "SVHO-0" + (count + 1);
        } else {
            return "SVHO-" + (count + 1);
        }
    }


    public String inputIdVilla() {
        Map<Facility, Integer> facilityIntegerMap = facilityController.getList();
        int count = 0;
        String[] str;
        for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
            str = map.getKey().getId().split("-");
            count = Integer.parseInt(str[1]);
        }
        if (count <= 9) {
            return "SVVL-000" + (count + 1);
        } else if (count <= 99) {
            return "SVVL-00" + (count + 1);
        } else if (count <= 999) {
            return "SVVL-0" + (count + 1);
        } else {
            return "SVVL-" + (count + 1);
        }
    }


    public Villa addVilla() {
        String id = inputIdVilla();
        System.out.println("Villa sẽ có ID là:  " + id);
        System.out.println("Nhập tên dịch vụ");
        String name = nameServiceCheck();
        System.out.println("Nhập diện tích sử dụng");
        int area = areaCheck();
        System.out.println("Nhập chi phí thuê");
        int price = checkPrice();
        System.out.println("Nhập số lượng người");
        int people = checkPeople();
        System.out.println("Chọn kiểu thuê");
        String type = choiceType();
        System.out.println("Chọn tiêu chuẩn phòng");
        String standard = choiceStandard();
        System.out.println("Nhập diện tích hồ bơi");
        int areaPool = areaCheck();
        System.out.println("Nhập số tầng");
        int floor = checkFloor();
        return new Villa(id, name, area, price, people, type, standard, areaPool, floor);
    }

    public void displayFacility() {
        Map<Facility, Integer> facilityIntegerMap = facilityController.getList();
        if (facilityIntegerMap.isEmpty()) {
            System.out.println("DS trống");
        } else {
            for (Map.Entry<Facility, Integer> facilityEntry : facilityIntegerMap.entrySet()) {
                System.out.println(facilityEntry.getKey() + "" + facilityEntry.getValue());
            }
        }
    }

    public void displayListMaintenance() {
        Map<Facility, Integer> facilityIntegerMap = facilityController.displayListMaintenance();
        if (facilityIntegerMap.isEmpty()) {
            System.out.println("DS trống");
        } else {
            for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
                System.out.println(facilityIntegerEntry.getKey() + "" + facilityIntegerEntry.getValue());
            }
        }
    }

    public String checkIdLive() {
        do {
            System.out.println("Nhập mã dịch vụ cần xóa ");
            String id = scanner.nextLine();
            Map<Facility, Integer> facilityIntegerMap = facilityController.getList();
            for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
                if (facilityIntegerEntry.getKey().getId().equals(id)) {
                    if (confirm()) {
                        System.out.println("Xóa thành công");
                        return id;
                    } else {
                        System.out.println("Bạn không xóa");
                        break;
                    }
                }
            }
            System.out.println("ID không tồn tại vui lòng nhập lại");
        } while (true);
    }

    public boolean confirm() {
        System.out.println("Bạn có muốn xóa không ? y/n");
        String check = scanner.nextLine();
        return check.equalsIgnoreCase("y");
    }
}
