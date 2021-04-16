package bai7_abstract_class_interface.bai_tap.resizeable_cho_cac_lop_hinh_hoc;

import bai7_.bai_tap.resizeable_cho_cac_lop_hinh_hoc.hih_hoc.Circle;
import bai7_.bai_tap.resizeable_cho_cac_lop_hinh_hoc.hih_hoc.Rectangle;

import bai7_.bai_tap.resizeable_cho_cac_lop_hinh_hoc.hih_hoc.Square;
import bai7_abstract_class_interface.bai_tap.resizeable_cho_cac_lop_hinh_hoc.hih_hoc.Shape;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int x= (int) Math.floor(Math.random()*10);
        Shape[] shapes=new Shape[3];
        shapes[0]= new Circle(x,"red",true);
        shapes[1]= new Rectangle(x,x,"blue",false);
        shapes[2]= new Square(x,"yellow",true);
       Arrays.toString(shapes);
        System.out.println("\n");
        for (Shape i: shapes) {
            i.resize(Math.random()*100);
            System.out.println(i.toString());
        }
        System.out.println("\n");
        Shape.printShape(shapes);
    }



}
