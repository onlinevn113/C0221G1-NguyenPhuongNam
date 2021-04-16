package bai4_ClassandObject_InJava.baiTap.phuongTrinhBacHai;

public class MainQuadraticEquation {
    public static void main(String[] args) {
        QuadraticEquation quadraticEquation=new QuadraticEquation();
        MethodQuadraticEquation methodQuadraticEquation=new MethodQuadraticEquation();
        quadraticEquation=quadraticEquation.enter();
        methodQuadraticEquation.giaPhuongTrinhBacHai(quadraticEquation);
    }
}
