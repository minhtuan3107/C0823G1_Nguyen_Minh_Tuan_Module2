package case_studyTest.model.facility;

public class Villa extends Facility {
    private double poolArea;
    private String standardVilla;
    private int numberOfFloors;
    public Villa(){
    }

    public Villa(String serviceCode, String serviceName, double acreage, double price, int maxPerson, String rentalType, double poolArea, String standardVilla, int numberOfFloors) {
        super(serviceCode, serviceName, acreage, price, maxPerson, rentalType);
        this.poolArea = poolArea;
        this.standardVilla = standardVilla;
        this.numberOfFloors = numberOfFloors;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public String getStandardVilla() {
        return standardVilla;
    }

    public void setStandardVilla(String standardVilla) {
        this.standardVilla = standardVilla;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "serviceCode=" + getServiceCode() +
                ", serviceName='" + getServiceName()+
                ", acreage=" + getAcreage() +
                ", price=" + getPrice() +
                ", maxPerson=" + getMaxPerson() +
                ", rentalType='" + getRentalType() + '\'' +
                "poolArea=" + poolArea +
                ", typeOfRoom='" + standardVilla + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}'+"\n";
    }
}
