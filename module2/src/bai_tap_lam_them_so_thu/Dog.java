package bai_tap_lam_them_so_thu;

public class Dog extends Animal {
    @Override
    void showSound() {
        System.out.println("Gầu gấu gâu gầu gâu");
    }

    public Dog() {
    }

    public Dog(String name, int age, String description) {
        super(name, age, description);
    }
}
