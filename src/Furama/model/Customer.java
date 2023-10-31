package Furama.model;

public class Customer extends Person {
    private String type;
    private String address;

    public Customer() {
    }

    public Customer(String id, String name, String birthday, String gender, int idNumber, int phone, String email, String type, String address) {
        super(id, name, birthday, gender, idNumber, phone, email);
        this.type = type;
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " Tên: " + getName() + " Ngày sinh: " + getBirthday() + " Giới tính: " + getGender() + " Số CCCD: " + getIdNumber() + " Số điện thoại: " + getPhone() + " Email: " + getEmail() + " Loại khách hàng: " + getType() + " Địa chỉ: " + getAddress();
    }
}
