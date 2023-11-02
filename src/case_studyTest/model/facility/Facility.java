package case_studyTest.model.facility;

public abstract class Facility {
    private String serviceCode;
    private String serviceName;
    private double acreage;
    private double price;
    private int maxPerson;
    private String rentalType;
    public Facility(){
    }

    public Facility(String serviceCode, String serviceName, double acreage, double price, int maxPerson, String rentalType) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.acreage = acreage;
        this.price = price;
        this.maxPerson = maxPerson;
        this.rentalType = rentalType;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Furama{" +
                "serviceCode=" + serviceCode +
                ", serviceName='" + serviceName + '\'' +
                ", acreage=" + acreage +
                ", price=" + price +
                ", maxPerson=" + maxPerson +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
