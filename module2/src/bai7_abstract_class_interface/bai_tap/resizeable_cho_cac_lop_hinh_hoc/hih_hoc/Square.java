package bai7_.bai_tap.resizeable_cho_cac_lop_hinh_hoc.hih_hoc;

import bai7_.bai_tap.colorable_cho_cac_lop_hinh_hoc.Colorable;
import bai7_abstract_class_interface.bai_tap.resizeable_cho_cac_lop_hinh_hoc.Resizeable;

public class Square extends bai7_.bai_tap.resizeable_cho_cac_lop_hinh_hoc.hih_hoc.Rectangle implements Colorable, Resizeable {
    public double side;
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is linked_list_don_gian subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        this.side*=(percent/200);
    }

    @Override
    public void colorable() {
        System.out.println("tô màu tràn viền hình vuông");
    }
}
