package ss05_access_modifier;

public class Company {
    private String name; //private để bao đóng
    private int phone;
    private String workingParts;
    private String nameCompany;

    @Override
    public String toString() {
        return "abc{" + "Tên '" + name + '\'' + ", SDT " + phone + ", Bộ phận làm việc '" + workingParts + '\'' + ", Tên công ty '" + nameCompany + '\'' + '}';
    }

    public Company() {
    }

    public Company(String name, int phone, String workingParts, String nameCompany) {
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
            Company company = new Company(); // tạo 1 đối tượng mới
            company.setName("Tuan"); // Set thông tin đối tượng
            company.setPhone(0123123123);
            company.setWorkingParts("Giám đốc");
            company.setNameCompany("Abc");
            System.out.println(company);
        }
    }
}
