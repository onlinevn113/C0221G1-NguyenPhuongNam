package bai10_dsa_danh_sach.bai_tap.bai1_arraylist;

import bai10_.bai_tap.bai1_arraylist.MyList;

public class TestMyList {
    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            Person person = (Person) obj;
            return this.name.equals(((Person) obj).name) && this.age == ((Person) obj).age;
        }
    }

    public static void main(String[] args) {
        MyList<Person> myList = new MyList<>();
        myList.ensureCapacity(5);
        myList.add(new Person("Nam1", 44));
        myList.add(new Person("Nam2", 45));
        myList.add(new Person("Nam3", 14));


        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
        System.out.println("\n");
        MyList<Person> myList2 = myList.clone();
        for (int i = 0; i < myList2.size(); i++) {
            System.out.println(myList.get(i).toString());
        }
        System.out.println("\n");

        int index = myList2.indexOf(new Person("Nam100", 14));
        System.out.println("index =" + index);

        System.out.println(myList.contains(new Person("Nam100",14)));

        myList.clear();

        for (int i = 0; i <myList.length() ; i++) {
            System.out.println(myList.get(i));
        }

    }
}
