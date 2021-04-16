package bai7_.bai_tap.resizeable_cho_cac_lop_hinh_hoc.hih_hoc;


import bai7_.bai_tap.colorable_cho_cac_lop_hinh_hoc.Colorable;
import bai7_abstract_class_interface.bai_tap.resizeable_cho_cac_lop_hinh_hoc.Resizeable;
import bai7_abstract_class_interface.bai_tap.resizeable_cho_cac_lop_hinh_hoc.hih_hoc.Shape;

public class Rectangle extends Shape implements Colorable, Resizeable {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getLength()
                + ", which is controllers subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        this.length+=(percent/200);
        this.width+=(percent/200);
    }

    @Override
    public void colorable() {
        System.out.println("tô màu xém tràn viền hình chử nhật");
    }
}
