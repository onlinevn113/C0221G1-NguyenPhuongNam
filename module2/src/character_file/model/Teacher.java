package character_file.model;

public class Teacher  extends Person{
    private String subjects;

    public Teacher(String subjects) {
        this.subjects = subjects;
    }

    public Teacher(String name, int age, String address, String subjects) {
        super(name, age, address);
        this.subjects = subjects;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + subjects;
    }
}
