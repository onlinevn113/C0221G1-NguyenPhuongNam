package Bai6_Kethua_Inheritance_Dahinh_Abstraction.baiTap.ClassCircle_andclassCylinder;

public class Cylinder extends Circle {
    private int h ;
    public Cylinder(double radius, String color,int h) {
        super(radius, color);
        this.h=h;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public double getTheTich(){
        return super.getArea()*h;
    }

    @Override
    public String toString() {
        return "cylinder{"
                + "h=" + h
                +"Thể tích"+getTheTich()
                + '}';
    }
}
