package Furama.model;

public class Employee extends Person {
    public String level;
    public String location;
    public int wage;

    public Employee() {
    }

    public Employee(String id, String name, String birthday, String gender, int idNumber, int phone, String email, String level, String location, int wage) {
        super(id, name, birthday, gender, idNumber, phone, email);
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " Tên: " + getName() + " Ngày sinh: " + getBirthday() + " Giới tính: " + getGender() + " Số CCCD: " + getIdNumber() + " Số điện thoại: " + getPhone() + " Email: " + getEmail() + " Trình độ: " + getLevel() + " Vị trí làm việc: " + getLocation() + " Lương: " + getWage();
    }
}
