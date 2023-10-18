package ss06_inheritance;

public class Cylinder extends Circle { // extends để ke thua Circle
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) { // overload
        super(radius, color); // dùng từ khóa supper để có thể gọi được các thành phần của lớp cha gần nó nhất
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * getHeight();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height + " " + super.toString() +
                '}';
    }
}
