package bai4_ClassandObject_InJava.baiTap.phuongTrinhBacHai;

public class MethodQuadraticEquation {
    public static void giaPhuongTrinhBacHai(QuadraticEquation quadraticEquation) {
        if (quadraticEquation.getA() == 0) {
            if (quadraticEquation.getB() == 0) {
                System.out.println("Phương trình vô nghiệm");
            } else {
                System.out.println("Phương trình có 1 nghiệm" + -quadraticEquation.getB() / quadraticEquation.getA());
            }

            return;
        }
        double delta = quadraticEquation.getB() * quadraticEquation.getB() - 4 * quadraticEquation.getA() * quadraticEquation.getC();
        double x1;
        double x2;
        double x;
        System.out.println(delta);
        if (delta > 0) {
            x1 = (-quadraticEquation.getB() + Math.sqrt(delta)) / 2 * quadraticEquation.getA();
            x2 = (-quadraticEquation.getB() - Math.sqrt(delta)) / 2 * quadraticEquation.getA();
            System.out.println("Phương trình có 2 nghiệm " + x1 + " và " + x2);
        } else if (delta == 0) {
            x = -quadraticEquation.getB() / 2 * quadraticEquation.getA();
            System.out.println("Phương trình có 1 nghiệm kép là " + x);
        } else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}
