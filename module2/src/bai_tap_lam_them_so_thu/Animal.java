package bai_tap_lam_them_so_thu;

import java.util.Scanner;

public abstract class Animal {
    protected String name;
    protected int age;
    protected String description;

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Animal(String name, int age, String description) {
        this.name = name;
        this.age = age;
        this.description = description;
    }

    void intput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap ten:");
        name = scan.nextLine();
        System.out.println("Nhap tuoi:");
        age = Integer.parseInt(scan.nextLine());
        System.out.println("Nhap mo ta:");
        description = scan.nextLine();
    }
    abstract  void showSound();



    public String display() {
        return "Animal{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
