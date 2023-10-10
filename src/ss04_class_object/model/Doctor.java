package ss04_class_object.model;

public class Doctor {
    private String name;
    private int old;
    private String location;
    private String email;
    private int phone;
    private String workPosition;

    public Doctor() {
    }

    public Doctor(String name, int old, String location, String email, int phone, String workPosition) {
        this.name = name;
        this.old = old;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.workPosition = workPosition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "Tên '" + name + '\'' +
                ", Tuổi " + old +
                ", Vị trí '" + location + '\'' +
                ", Số điện thoại " + phone +
                ", Vị trí làm việc'" + workPosition + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }
}
