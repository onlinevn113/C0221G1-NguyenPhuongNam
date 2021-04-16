package bai7_.thuc_hanh.so_sanh_cac_lop_hinh_hoc;

import Bai6_Kethua_Inheritance_Dahinh_Abstraction.thucHanh.heHinhHoc.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }
}