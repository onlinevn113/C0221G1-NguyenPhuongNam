package demo_ngay9_thang4_compar;


import java.util.Comparator;

public class NameComparatorOfStudent implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
