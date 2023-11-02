package case_studyTest.model.facility;

public class House extends Facility {
    private String typeOfRoom;
    private int numberOfFloors;
    public House(){

    }

    public House(String typeOfRoom, int numberOfFloors) {
        this.typeOfRoom = typeOfRoom;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String serviceCode, String serviceName, double acreage, double price, int maxPerson, String rentalType, String typeOfRoom, int numberOfFloors) {
        super(serviceCode, serviceName, acreage, price, maxPerson, rentalType);
        this.typeOfRoom = typeOfRoom;
        this.numberOfFloors = numberOfFloors;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" + "serviceCode=" + getServiceCode() +
                ", serviceName='" + getServiceName()+
                ", acreage=" + getAcreage() +
                ", price=" + getPrice() +
                ", maxPerson=" + getMaxPerson() +
                ", rentalType='" + getRentalType()+
                "typeOfRoom='" + typeOfRoom + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}'+"\n";
    }
}
