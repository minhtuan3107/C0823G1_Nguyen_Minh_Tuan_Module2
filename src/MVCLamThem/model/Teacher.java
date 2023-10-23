package MVCLamThem.model;

public class Teacher extends Person {
    private String Specialize;

    public String getSpecialize() {
        return Specialize;
    }

    public Teacher() {
    }

    public Teacher(String id, String name, String birthday, String gender, String specialize) {
        super(id, name, birthday, gender);
        Specialize = specialize;
    }

    public void setSpecialize(String specialize) {
        Specialize = specialize;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", birthday='" + getBirthday() + '\'' +
                ", gender='" + getGender() + '\'' +
                "Specialize='" + Specialize + '\'' +
                '}';
    }
}
