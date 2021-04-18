package bai13_thuat_toan_tim_kiem.thuc_hanh.tinh_do_phuc_tap_cua_thuat_toan;

import java.util.Scanner;

public class AlgorithmComplexityTest<i> {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter controllers string:");
        String inputString = scanner.nextLine();
        /*codes below here */

        int[] frequentChar = new int[255];
        for (int i = 0; i < inputString.length(); i++) {
            /* Tìm ví trí tương ứng của ký tự trong bảng ASCII */
            int ascii = (int) inputString.charAt(i);
            /* Tăng giá trị tần suất */
            frequentChar[ascii] += 1;
        }
        int max = 0;
        char character = (char) 255;
        for (int j = 0; j < 255; j++) {
            if (frequentChar[j] > max) {
                max = frequentChar[j];
                character = (char) j;
            }
        } System.out.println("The most appearing letter is '" + character + "' with controllers frequency of " + max + " times");
    }
}