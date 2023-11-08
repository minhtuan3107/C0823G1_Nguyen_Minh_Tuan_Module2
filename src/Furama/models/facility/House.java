package Furama.models.facility;

public class House extends Facility {
    private String standard;
    private int floor;

    public House() {
    }

    public House(String id, String name, int acreage, int price, int people, String type, String standard, int floor) {
        super(id, name, acreage, price, people, type);
        this.standard = standard;
        this.floor = floor;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", acreage=" + getAcreage() +
                ", price=" + getPrice() +
                ", people=" + getPeople() +
                ", type='" + getType() + '\'' +
                "standard='" + standard + '\'' +
                ", floor=" + floor +
                '}';
    }
}
