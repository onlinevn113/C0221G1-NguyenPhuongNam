package testzone;

import java.util.Date;

public class formattingFrintf {
    public static void main(String[] args) {
        double test=10.2,test1=20.5;
//        định dạng string
        System.out.printf("%-3.2s %n", "Hi there!");
//        định dạng số nguyên dấu phân cách ngàn
        System.out.printf( "%,d %n", 100000);
//        định dạng kép
        System.out.printf("%1.3e%n",5.1473);
//        định dạng float
        System.out.printf("%20f%n",  test,test1);
//        định dạng thời gian
//        testmang
        Date date = new Date();
        System.out.printf("%tT%n", date);
        //hmS
        System.out.printf("hours %tH: minutes %tM: seconds %tS%n", date, date, date);

        System.out.printf("%1$tH:%1$tM:%1$tS %1$tp %1$tL %1$tN %1$tz %n", date);

        System.out.printf("%1$tA, %1$td %1$tB %1$tY %n", date);

        System.out.printf("%1$td.%1$tm.%1$ty %n", date);

        System.out.printf("%1$td.%1$tm.%1$ty %n", date);


    }
}
