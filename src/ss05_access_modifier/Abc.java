package ss05_access_modifier;

public class Abc {
    private String name; //private để bao đóng
    private int phone;//private để bao đóng
    private String workingParts;//private để bao đóng
    private String nameCompany;//private để bao đóng

    @Override
    public String toString() {
        return "abc{" + "Tên '" + name + '\'' + ", SDT " + phone + ", Bộ phận làm việc '" + workingParts + '\'' + ", Tên công ty '" + nameCompany + '\'' + '}';
    }

    public Abc() {
    }

    public Abc(String name, int phone, String workingParts, String nameCompany) {
        this.name = name;
        this.phone = phone;
        this.workingParts = workingParts;
        this.nameCompany = nameCompany;
    }

    //getter và setter là public để sửa và xem giá trị qua phương thức thay vì trực tiếp
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getWorkingParts() {
        return workingParts;
    }

    public void setWorkingParts(String workingParts) {
        this.workingParts = workingParts;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public static class Main { //Main sử dụng từ khóa static để truy cập trực tiếp
        public static void main(String[] args) {
            Abc abc = new Abc(); // tạo 1 đối tượng mới
            abc.setName("Tuan"); // Set thông tin cho đối tượng
            abc.setPhone(0123123123);
            abc.setWorkingParts("Giám đốc");
            abc.setNameCompany("Abc");
            System.out.println(abc);
        }
    }
}
