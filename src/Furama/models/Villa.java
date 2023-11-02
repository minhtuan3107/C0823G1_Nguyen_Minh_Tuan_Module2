package Furama.models;

public class Villa extends Facility {
    private String standard;
    private int areaPool;
    private int floor;


    public Villa(String id, String name, int acreage, int price, int people, String type, String standard, int areaPool, int floor) {
        super(id, name, acreage, price, people, type);
        this.standard = standard;
        this.areaPool = areaPool;
        this.floor = floor;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(int areaPool) {
        this.areaPool = areaPool;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", acreage=" + getAcreage() +
                ", price=" + getPrice() +
                ", people=" + getPeople() +
                ", type='" + getType() + '\'' +
                "standard='" + standard + '\'' +
                ", areaPool=" + areaPool +
                ", floor=" + floor +
                '}';
    }
}
