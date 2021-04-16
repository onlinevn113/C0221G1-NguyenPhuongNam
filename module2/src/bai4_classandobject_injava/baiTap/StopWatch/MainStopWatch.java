package bai4_classandobject_injava.baiTap.StopWatch;

import java.util.Arrays;

public class MainStopWatch {
    public static void main(String[] args) {
        int [] arr=new int[100000];
        for (int i = 0; i <100000 ; i++) {
            arr[i]=(int) (Math.random()*100);
            System.out.println(arr[i]);
        }
        bai4_ClassandObject_InJava.baiTap.StopWatch.StopWatch stopWatch=new bai4_ClassandObject_InJava.baiTap.StopWatch.StopWatch();
        stopWatch.start();
        Arrays.sort(arr);
        stopWatch.stop();
        System.out.println("Second is "+stopWatch.getElapsedTime());
    }
}
