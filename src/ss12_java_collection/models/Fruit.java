package ss12_java_collection.models;

public class Fruit {
    private int idFruit;
    private String nameFruit;
    private String typeFruit;
    private String date;
    private String expiry;
    private String origin;
    private int price;

    public Fruit(int idFruit, String nameFruit, String typeFruit, String date, String expiry, String origin, int price) {
        this.idFruit = idFruit;
        this.nameFruit = nameFruit;
        this.typeFruit = typeFruit;
        this.date = date;
        this.expiry = expiry;
        this.origin = origin;
        this.price = price;
    }

    public Fruit() {
    }

    public int getIdFruit() {
        return idFruit;
    }

    public void setIdFruit(int idFruit) {
        this.idFruit = idFruit;
    }

    public String getNameFruit() {
        return nameFruit;
    }

    public void setNameFruit(String nameFruit) {
        this.nameFruit = nameFruit;
    }

    public String getTypeFruit() {
        return typeFruit;
    }

    public void setTypeFruit(String typeFruit) {
        this.typeFruit = typeFruit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "idFruit=" + idFruit +
                ", nameFruit='" + nameFruit + '\'' +
                ", typeFruit='" + typeFruit + '\'' +
                ", date='" + date + '\'' +
                ", expiry='" + expiry + '\'' +
                ", origin='" + origin + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}