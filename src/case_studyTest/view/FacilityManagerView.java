package case_studyTest.view;

import case_studyTest.controller.FacilityController;
import case_studyTest.model.facility.House;
import case_studyTest.model.facility.Room;
import case_studyTest.model.facility.Villa;
import case_studyTest.util.Regex;

import java.util.Scanner;

public class FacilityManagerView {
    private final FacilityController facilityController = new FacilityController();
    private final Scanner scanner = new Scanner(System.in);

    public void displayFacilityMenu() {
        System.out.println("---Facility Menu---");
        System.out.println("1. Hiển thị cơ sở vật chất");
        System.out.println("2. Thêm mới facility");
        System.out.println("3. Hiển thị facility cần bảo trì");
        System.out.println("4. Xóa facility");
        System.out.println("5. Trở về menu");
    }

    public int inputOption() {
        int option = 0;
        do {
            try {
                System.out.println("Mời chọn chức năng ");
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (option <= 0 || option > 5);
        return option;
    }

    public void handleFacilityManagementOption(int option) {

        switch (option) {
            case 1:
                System.out.println(facilityController.display());
                break;
            case 2:
                facilityAddDetailMenu();
                break;
            case 3:
                System.out.println(facilityController.displayListMaintenance());
                break;
            case 4:
                String id;
                System.out.println("Nhập mã dịch vụ ");
                id = scanner.nextLine();
                facilityController.delete(id);
                break;
            case 5:
                break;
        }
    }

    public void facilityMenu() {
        int temp;
        do {
            displayFacilityMenu();
            temp = inputOption();
            handleFacilityManagementOption(temp);
        } while (temp != 5);
    }

    public void displayAddNewFacility() {
        System.out.println("1. Thêm mới Villa");
        System.out.println("2. Thêm mới House");
        System.out.println("3. Thêm mới Room");
        System.out.println("4. Trở về menu");
    }

    public void handleAddNewFacility(int option) {
        switch (option) {
            case 1:
                Villa villa = new Villa();
                villa.setServiceCode(inputServiceCode("SVVL-"));
                villa.setServiceName(inputServiceName());
                villa.setAcreage(inputAcreage());
                villa.setPrice(inputPrice());
                villa.setMaxPerson(inputMaxPerson());
                villa.setRentalType(inputRentalType());
                villa.setPoolArea(inputPoolArea());
                villa.setStandardVilla(inputTypeOfRoom());
                villa.setNumberOfFloors(inputNumberOfFloors());
                facilityController.add(villa);
                break;
            case 2:
                House house = new House();
                house.setServiceCode(inputServiceCode("SVHO-"));
                house.setServiceName(inputServiceName());
                house.setAcreage(inputAcreage());
                house.setPrice(inputPrice());
                house.setMaxPerson(inputMaxPerson());
                house.setRentalType(inputRentalType());
                house.setTypeOfRoom(inputTypeOfRoom());
                house.setNumberOfFloors(inputNumberOfFloors());
                facilityController.add(house);
                break;
            case 3:
                Room room = new Room();
                room.setServiceCode(inputServiceCode("SVRO-"));
                room.setServiceName(inputServiceName());
                room.setAcreage(inputAcreage());
                room.setPrice(inputPrice());
                room.setMaxPerson(inputMaxPerson());
                room.setRentalType(inputRentalType());
                room.setFreeService(inputFreeService());
                facilityController.add(room);
                break;
            case 4:
                break;
        }
    }

    public void displayDetailFacility() {
        System.out.println("1. Villa");
        System.out.println("2. House");
        System.out.println("3. Room");
        System.out.println("4. Trở về menu");
    }

    public int inputMiniOption() {
        int option = 0;
        do {
            try {
                System.out.println("Vui lòng chọn 1 - 3");
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (option <= 0 || option > 4);
        return option;
    }

    public void facilityAddDetailMenu() {
        int temp;
        do {
            displayAddNewFacility();
            temp = inputOption();
            handleAddNewFacility(temp);
        } while (temp != 4);
    }

    public String inputServiceCode(String code) {
        String serviceCode = code;
        String inputCode;
        do {
            System.out.println(code + " Mời nhập 4 số vd : 1234");
            inputCode = scanner.nextLine();
        } while (!Regex.codeValidate(inputCode));
        serviceCode = serviceCode.concat(inputCode);
        return serviceCode;
    }

    public String inputServiceName() {
        String serviceName;
        do {
            System.out.println("Nhập tên dịch vụ");
            serviceName = scanner.nextLine();
        } while (!Regex.nameValidate(serviceName));
        return serviceName;
    }

    public double inputAcreage() {
        double acreage;
        System.out.println("Nhập diện tích");
        acreage = Double.parseDouble(scanner.nextLine());
        return acreage;
    }

    public double inputPrice() {
        double price;
        System.out.println("Nhập giá tiền");
        price = Double.parseDouble(scanner.nextLine());
        return price;
    }

    public int inputMaxPerson() {
        int maxPerson;
        System.out.println("Nhập số người tối đa");
        maxPerson = Integer.parseInt(scanner.nextLine());
        return maxPerson;
    }

    public String inputRentalType() {
        String rentalType;
        System.out.println("Nhập loại dịch vụ");
        rentalType = scanner.nextLine();
        return rentalType;
    }

    public double inputPoolArea() {
        double poolArea;
        System.out.println("Nhập diện tích hồ bơi");
        poolArea = Double.parseDouble(scanner.nextLine());
        return poolArea;
    }

    public String inputTypeOfRoom() {
        String typeOfRoom;
        System.out.println("Nhập loại phòng");
        typeOfRoom = scanner.nextLine();
        return typeOfRoom;
    }

    public int inputNumberOfFloors() {
        int numberOfFloors;
        System.out.println("Nhập so tầng");
        numberOfFloors = Integer.parseInt(scanner.nextLine());
        return numberOfFloors;
    }

    public String inputFreeService() {
        String freeService;
        System.out.println("Nhập tên dịch vụ miễn phí ");
        freeService = scanner.nextLine();
        return freeService;
    }
}
