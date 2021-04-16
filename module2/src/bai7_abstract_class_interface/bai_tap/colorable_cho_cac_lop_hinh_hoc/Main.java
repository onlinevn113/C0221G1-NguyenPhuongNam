package bai7_.bai_tap.colorable_cho_cac_lop_hinh_hoc;

import bai7_.bai_tap.resizeable_cho_cac_lop_hinh_hoc.hih_hoc.Circle;
import bai7_.bai_tap.resizeable_cho_cac_lop_hinh_hoc.hih_hoc.Rectangle;
import bai7_.bai_tap.resizeable_cho_cac_lop_hinh_hoc.hih_hoc.Square;

public class Main {
    public static void main(String[] args) {
        Square square= new Square(3,"purple",true);
        square.colorable();
        System.out.println(square);
        Rectangle rectangle = new Rectangle(3,3,"white",true);
        rectangle.colorable();
        System.out.println(rectangle);
        Circle circle=new Circle(3,"red",false);
        circle.colorable();
        System.out.println(circle);
    }
}
