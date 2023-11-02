package case_studyTest.model.facility;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String serviceCode, String serviceName, double acreage, double price, int maxPerson, String rentalType, String freeService) {
        super(serviceCode, serviceName, acreage, price, maxPerson, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" + "serviceCode=" + getServiceCode() +
                ", serviceName='" + getServiceName()+
                ", acreage=" + getAcreage() +
                ", price=" + getPrice() +
                ", maxPerson=" + getMaxPerson() +
                ", rentalType='" + getRentalType()+
                "freeService='" + freeService + '\'' +
                '}'+"\n";
    }
}
