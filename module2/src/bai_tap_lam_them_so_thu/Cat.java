package bai_tap_lam_them_so_thu;

public class Cat extends Animal {
    @Override
    void showSound() {
        System.out.println("Mèo méo meo mèo meo");
    }

    public Cat() {
    }

    public Cat(String name, int age, String description) {
        super(name, age, description);
    }
}
