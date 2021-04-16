package demo_ngay9_thang4_compar;


public class Student implements Comparable<Student> {
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


    @Override
    public int compareTo(Student o) {
        if (this.age > o.getAge()) {
            return 1;
        } else if (this.age == o.getAge()) {
            if(this.name.compareTo(o.getName())>0) {
                return 1;
            } else if(this.name.equals(o.getName())) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", MSSV=" + MSSV +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
//        Student[] students = new Student[5];
//        students[0] = new Student("Hai",1234,12);
//        students[1] = new Student("Hai",1234,10);
//        students[2] = new Student("Hai",1234,20);
//        students[3] = new Student("Hai",1234,18);
//        students[4] = new Student("Hai",1234,19);
//        Arrays.sort(students, new AgeComparatorOfStudent());
//        for(Student student: students) {
//            System.out.println(student);
//        }

        String linked_list_don_gian = "Hello";
        String b = "Hello";
        String c = linked_list_don_gian+b;
        String d = linked_list_don_gian+b;
        System.out.println(c.equals(d));
    }
}
