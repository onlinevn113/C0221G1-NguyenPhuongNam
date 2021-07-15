package com;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 1002, 3};
        System.out.println(new Main().findSecondMaxNumber(arr));

    }

    public int secondMax(int[] arr) {
        if (arr.length < 2) {
            return arr[0];
        } else {
            int max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            String temp = "";
            for (int a = 0; a < arr.length; a++) {
                if (arr[a] < max) {
                    temp += arr[a];
                }
            }
            String[] tempNew = temp.split("");
            int maxNew = Integer.parseInt(tempNew[0]);
            for (int b = 0; b < tempNew.length; b++) {
                if (Integer.parseInt(tempNew[b]) > maxNew) {
                    maxNew = Integer.parseInt(tempNew[b]);
                }
            }
            return maxNew;
        }
    }

    public int findSecond(int[] arr) {
        Arrays.sort(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] != arr[i - 1]) {
                return arr[i - 1];
            }
        }
        return 0;
    }

    public static int findSecondMaxNumber(int[] arr) {
        int temp;
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        int num = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                num = max;
                max = arr[i];
            }
        }
        return num;
    }
//    public static int secondLargest(int[] a,int totalElement) {
//        int temp;
//        for (int i=0; i < totalElement; i++) {
//            for (int j=i+1;j<totalElement;j++) {
//                if (a[i]>a[j]) {
//                    temp=a[i];
//                    a[i] = a[j];
//                    a[j] = temp;
//                }
//            }
//        }
//        return a[totalElement-2];
//    }

}
