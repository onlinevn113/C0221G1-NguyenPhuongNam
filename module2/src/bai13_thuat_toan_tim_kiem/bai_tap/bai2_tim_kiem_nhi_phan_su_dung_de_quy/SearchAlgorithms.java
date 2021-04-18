package bai13_thuat_toan_tim_kiem.bai_tap.bai2_tim_kiem_nhi_phan_su_dung_de_quy;

import java.util.Arrays;

public class SearchAlgorithms {
    static int binarySearch(int[] array, int left, int right, int value) {

        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (value > array[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {123123, 4, 2, 5, 6, 7, 10, 100, 200, 330, 4999};
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;

        System.out.println(binarySearch(array, left, right, 123123));
        System.out.println(binarySearch(array, left, right, 4));
        System.out.println(binarySearch(array, left, right, 330));
        System.out.println(binarySearch(array, left, right, 4999));


    }
}
