package bai7_abstract_class_interface.bai_tap.resizeable_cho_cac_lop_hinh_hoc.hih_hoc;

import bai7_.bai_tap.colorable_cho_cac_lop_hinh_hoc.Colorable;

import bai7_abstract_class_interface.bai_tap.resizeable_cho_cac_lop_hinh_hoc.Resizeable;

public abstract class Shape implements Resizeable,Colorable {
    private String color = "green";
    private boolean filled = true;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with color of "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled");
    }
    public static void printShape(Shape[] shapes){
        for (Shape i: shapes) {
            System.out.println(i.toString());
        }
    }

    public abstract void resize(double v);
}