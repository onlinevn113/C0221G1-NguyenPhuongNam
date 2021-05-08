package demo_ngay9_thang4_compar;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {
    private String name;
    private long MSSV;
    private int age;

    public Student() {
    }

    public Student(String name, long MSSV, int age) {
        this.name = name;
        this.MSSV = MSSV;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMSSV() {
        return MSSV;
    }

    public void setMSSV(long MSSV) {
        this.MSSV = MSSV;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


//    @Override
//    public int compareTo(Student o) {
//        if (this.age > o.getAge()) {
//            return 1;
//        } else if (this.age == o.getAge()) {
//            if(this.name.compareTo(o.getName())>0) {
//                return 1;
//            } else if(this.name.equals(o.getName())) {
//                return 0;
//            } else {
//                return -1;
//            }
//        } else {
//            return -1;
//        }
//    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", MSSV=" + MSSV +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Student student5 = new Student("Er", 20, 5);
        Student student2 = new Student("Bình", 20, 2);
        Student student1 = new Student("An", 20, 11);
        Student student3 = new Student("Ca", 20, 3);
        Student student4 = new Student("De", 20, 4);


        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.sort(Comparator.comparing(Student::getName).thenComparing(Student::getAge));

//        studentList.sort(Comparator.reverseOrder());
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
