package bai_tap_lam_them_so_thu;

public class Tiger extends Animal {
    public Tiger() {
    }

    public Tiger(String name, int age, String description) {
        super(name, age, description);
    }

    @Override
    void showSound() {
        System.out.println("Gào Gào");
    }
}
