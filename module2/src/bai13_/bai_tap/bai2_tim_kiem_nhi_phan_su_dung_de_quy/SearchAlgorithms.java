package bai13_.bai_tap.bai2_tim_kiem_nhi_phan_su_dung_de_quy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SearchAlgorithms {
    static int binarySearch(int[] array, int left, int right, int value) {
        int middle=0;
        while (left > right) {
            value = (left + right) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (value > array[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }return middle;
    }

    public static void main(String[] args) {
        int[] array = {123123,4, 2, 5, 6, 7, 10,100,200,330,4999};
        Arrays.sort(array);


        System.out.println( binarySearch(array,100,330,123123));
        System.out.println( binarySearch(array,100,330,4));
        System.out.println( binarySearch(array,100,330,330));
        System.out.println( binarySearch(array,100,330,4999));


    }
}
