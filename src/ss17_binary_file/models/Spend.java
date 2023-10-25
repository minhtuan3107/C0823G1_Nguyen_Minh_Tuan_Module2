package ss17_binary_file.models;

public class Spend {
    private int id;
    private String name;
    private String date;
    private int price;
    private String des;
    public Spend(){}
    public Spend(int id, String name, String date, int price, String des) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.price = price;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Spend{" +
                "ID=" + id +
                ", Tên ='" + name + '\'' +
                ", Ngày ='" + date + '\'' +
                ", Tiền =" + price +
                ", Mô tả='" + des + '\'' +
                '}';
    }
}
