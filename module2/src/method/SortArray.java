package method;

public class SortArray {
    public static int[] sortArr(int [] arr) {
        int temp = arr[0];
        // code here
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[]arr={1,2,3,4,987,65,3653,22,11,0};
        System.out.println( sortArr(arr));

    }
}
