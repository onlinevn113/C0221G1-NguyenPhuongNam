package testzone;

public class EqualExample1 {
    public static void main(String[] args) {
        String s1 = new String("This is Queue_lien_ket_vong string");
        String s2 = new String("This is Queue_lien_ket_vong string");

        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equals(s2): " + (s1.equals(s2)));
    }
}
