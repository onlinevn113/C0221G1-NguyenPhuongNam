package method;

import java.util.List;

public class Test {
    private int[]sort(int [] arr){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
    public static void main(String[] args) {
      int [] arr={1,2,3,4,5,10,0,100,7,20};
        Test test=new Test();
        System.out.println(test.sort(arr));
    }
}
