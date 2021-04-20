package bai_tap_lam_them_so_thu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Room {
    int roomNo;
    List<Animal> animalList = new ArrayList<>();

    public Room() {
    }

    public Room(int roomNo) {
        this.roomNo = roomNo;
    }

    public Room(int roomNo, List<Animal> animalList) {
        this.roomNo = roomNo;
        this.animalList = animalList;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }


    void addAnimal(Animal a) {
        animalList.add(a);
    }

    void removeAnimal(String name) {
        for (Animal removeAnimal : animalList) {
            if (removeAnimal.getName().equalsIgnoreCase(name)) {
                animalList.remove(removeAnimal);
            }
        }
    }

    void display() {
        for (Animal animal : animalList) {
            System.out.println(animal.display());
            animal.showSound();
        }

    }

    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã chuồng");
        roomNo = Integer.parseInt(scanner.nextLine());

    }

    public  Animal createAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chọn\n" +
                "1. Khởi tạo Tiger\n" +
                "2. Khởi tạo Dog\n" +
                "3. Khởi tạo Cat\n");
        int input = Integer.parseInt(scanner.nextLine());
        Animal animal = null;
        switch (input) {
            case 1:
                animal = new Tiger();
                animal.intput();
                break;
            case 2:
                animal = new Dog();
                animal.intput();
                break;
            case 3:
                animal = new Cat();
                animal.intput();
                break;
            default:
                System.out.println("Nhập lại");

        }

        return animal;
    }
}
