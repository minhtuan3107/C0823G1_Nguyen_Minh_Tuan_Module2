package case_studyTest.model.person;

public class Customer extends Person {
    private String idCustomer;
    private String typeOfCustomer;
    private String address;

    public Customer() {
    }

    public Customer(String name, String dateOfBirth, String gender, String idCard, String phoneNumber, String email, String idCustomer, String typeOfCustomer, String address) {
        super(name, dateOfBirth, gender, idCard, phoneNumber, email);
        this.idCustomer = idCustomer;
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer='" + idCustomer + '\'' +
                "Name='" + getName() + '\'' +
                "DOB='" + getDateOfBirth() + '\'' +
                "Gender='" + getGender() + '\'' +
                "Id card='" + getIdCard() + '\'' +
                "Phone number='" + getPhoneNumber() + '\'' +
                "Email='" + getEmail() + '\'' +
                ", typeOfCustomer='" + typeOfCustomer + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
