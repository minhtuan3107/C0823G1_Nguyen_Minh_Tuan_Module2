package MVCLamThem.model;

public class Student extends Person {
    private String classRom;
    private int point;

    public Student() {
    }

    public Student(String id, String name, String birthday, String gender, String classRom, int point) {
        super(id, name, birthday, gender);
        this.classRom = classRom;
        this.point = point;
    }

    public String getClassRom() {
        return classRom;
    }

    public void setClassRom(String classRom) {
        this.classRom = classRom;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", birthday='" + getBirthday() + '\'' +
                ", gender='" + getGender() + '\'' +
                "classRom='" + classRom + '\'' +
                ", point=" + point +
                '}';
    }
}
