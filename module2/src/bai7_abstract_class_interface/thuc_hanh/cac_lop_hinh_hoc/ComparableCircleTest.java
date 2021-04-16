package bai7_abstract_class_interface.thuc_hanh.cac_lop_hinh_hoc;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        bai7_.thuc_hanh.cac_lop_hinh_hoc.ComparableCircle[] circles = new bai7_.thuc_hanh.cac_lop_hinh_hoc.ComparableCircle[3];
        circles[0] = new bai7_.thuc_hanh.cac_lop_hinh_hoc.ComparableCircle(3.6);
        circles[1] = new bai7_.thuc_hanh.cac_lop_hinh_hoc.ComparableCircle();
        circles[2] = new bai7_.thuc_hanh.cac_lop_hinh_hoc.ComparableCircle(3.5, "indigo", false);

        System.out.println("Pre-sorted:");
        for (bai7_.thuc_hanh.cac_lop_hinh_hoc.ComparableCircle circle : circles) {
            System.out.println(circle);
        }

        Arrays.sort(circles);

        System.out.println("After-sorted:");
        for (bai7_.thuc_hanh.cac_lop_hinh_hoc.ComparableCircle circle : circles) {
            System.out.println(circle);
        }
    }
}
