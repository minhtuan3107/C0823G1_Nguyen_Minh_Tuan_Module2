package Furama.models;

public class Room extends Facility {
    private String serviceFree;

    public Room() {
    }

    public Room(String id, String name, int acreage, int price, int people, String type, String serviceFree) {
        super(id, name, acreage, price, people, type);
        this.serviceFree = serviceFree;
    }

    public String getServiceFree() {
        return serviceFree;
    }

    public void setServiceFree(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", acreage=" + getAcreage() +
                ", price=" + getPrice() +
                ", people=" + getPeople() +
                ", type='" + getType() + '\'' +
                "serviceFree='" + serviceFree + '\'' +
                '}';
    }
}
