package bai19_.bai_tap.crawl_tin_tuc;

public class Testttt {
    public Testttt() {
    }

    public static void main(String[] args) {

        String msg = "codegym";
        for(int x = -2; x < msg.length() - 2; x++)
        {
            if(msg.length() == 3)
            {
                for (int i = 2; i < 7; i++)
                {
                    System.out.println(i);
                }
            }
            else
            {
                for (int i = msg.length();  i > (msg.length() - 2); i--)
                {
                    System.out.println(i);
                }
            }
        }
    }
}
