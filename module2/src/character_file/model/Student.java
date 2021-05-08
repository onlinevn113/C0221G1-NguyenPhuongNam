package character_file.model;

public class Student extends Person {
    private String classStudent;
    private double point;

    public Student(String classStudent, double point) {
        this.classStudent = classStudent;
        this.point = point;
    }

    public Student(String name, Integer age, String address, String classStudent, Double point) {
        super(name, age, address);
        this.classStudent = classStudent;
        this.point = point;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return super.toString()+
                "," + classStudent +
                "," + point;
    }
}
