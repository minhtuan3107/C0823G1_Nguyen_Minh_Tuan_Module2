package case_studyTest.model.person;

public class Employee extends Person {
private String idEmployee;
private String academicLevel;
private String jobPosition;
private String salary;

public Employee(){}
    public Employee(String name, String dateOfBirth, String gender, String idCard, String phoneNumber, String email, String idEmployee, String academicLevel, String jobPosition, String salary) {
        super(name, dateOfBirth, gender, idCard, phoneNumber, email);
        this.idEmployee = idEmployee;
        this.academicLevel = academicLevel;
        this.jobPosition = jobPosition;
        this.salary =salary;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee='" + idEmployee + '\'' +
                "Name='" + getName() + '\'' +
                "DOB='" + getDateOfBirth() + '\'' +
                "Gender='" + getGender() + '\'' +
                "Id card='" + getIdCard() + '\'' +
                "Phone number='" + getPhoneNumber() + '\'' +
                "Email='" + getEmail() + '\'' +
                ", academicLevel='" + academicLevel + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                ", salary='" + salary + '\'' +
                '}' +"\n";
    }
}
