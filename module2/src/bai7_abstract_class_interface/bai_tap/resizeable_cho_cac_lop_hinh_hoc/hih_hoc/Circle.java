package bai7_.bai_tap.resizeable_cho_cac_lop_hinh_hoc.hih_hoc;


import bai7_.bai_tap.colorable_cho_cac_lop_hinh_hoc.Colorable;
import bai7_abstract_class_interface.bai_tap.resizeable_cho_cac_lop_hinh_hoc.Resizeable;
import bai7_abstract_class_interface.bai_tap.resizeable_cho_cac_lop_hinh_hoc.hih_hoc.Shape;

public class Circle extends Shape implements Colorable, Resizeable {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) { this.radius = radius; }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }


    @Override
    public void resize(double percent) {
        this.radius*=(percent/200);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +" color "+getColor()+
                '}';
    }

    @Override
    public void colorable() {
        System.out.println("tô màu tràn hết viền hình tròn ");
    }
}
