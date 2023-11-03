package Furama.models;

public class Contract {
    private String id;
    private String idBooking;
    private String deposit;
    private String price;

    public Contract(String id, String idBooking, String deposit, String price) {
        this.id = id;
        this.idBooking = idBooking;
        this.deposit = deposit;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Hợp đồng mã: " + id + " mã booking: " + idBooking + " số tiền cọc trước: " + deposit + " tổng tiền phải thanh toán " + price;
    }
}
