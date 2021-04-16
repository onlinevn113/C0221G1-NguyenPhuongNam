package bai2_loopInJava.baiTap;

public class HienThiCacSoNguyenToNhoHon100 {
    public static boolean kiemTraNguyenTo(double num) {
        boolean check = true;
        if (num < 2) {
            check = false;
        }
        for (int i = 2; i <num; i++) {
            if (num % i == 0) {
                check = false;
            }
        }
        return check;

    }
    public static void main(String[] args) {
        int i = 2;
        while (i < 100) {
            if (kiemTraNguyenTo(i)) {
                System.out.println(i+" ");
            }
            i++;
        }
    }

}
