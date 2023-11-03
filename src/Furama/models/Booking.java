package Furama.models;

public class Booking {
    public String id;
    public String dateBooking;
    public String dayStart;
    public String dayEnd;
    public String idCustomer;
    public String idService;

    public Booking() {
    }

    public Booking(String id, String dateBooking, String dayStart, String dayEnd, String idCustomer, String idService) {
        this.id = id;
        this.dateBooking = dateBooking;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.idCustomer = idCustomer;
        this.idService = idService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(String dateBooking) {
        this.dateBooking = dateBooking;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    @Override
    public String toString() {
        return "Booking: " + " Mã booking: " + id + " ngày booking " + dateBooking + " ngày bắt đầu thuê: " + dayStart + " ngày kết thúc thuê: " + dayEnd + " mã khách hàng: " + idCustomer + " mã dịch vụ: " + idService;
    }
}
