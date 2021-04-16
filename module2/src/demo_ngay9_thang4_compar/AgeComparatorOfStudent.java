package demo_ngay9_thang4;

import demo_ngay9_thang4_compar.Student;

import java.util.Comparator;

public class AgeComparatorOfStudent implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAge()>o2.getAge()) {
            return 1;
        } else if(o1.getAge() == o2.getAge()) {
            return o1.getName().compareTo(o2.getName());
        }
        else {
            return -1;
        }
    }
}
