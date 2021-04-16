package Bai6_Kethua_Inheritance_Dahinh_Abstraction.baiTap.lop_point_moveablepoint;

public class MainPoint {
    public static void main(String[] args) {
       Point point=new Point(10,20);
       point=new MoveablePoint(point.getX(),point.getY(),20,20);
        System.out.println(point);
    }
}
