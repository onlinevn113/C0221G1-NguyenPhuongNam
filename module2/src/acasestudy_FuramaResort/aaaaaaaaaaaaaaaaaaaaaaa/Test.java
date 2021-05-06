package acasestudy_FuramaResort.aaaaaaaaaaaaaaaaaaaaaaa;

import java.util.*;

public class Test {
    private String name;

    public Test(String name) {
        this.name = name;
    }
    public static int recursion (int x, int y) {
        if (x == 1)
            return y;
        else
            return y * recursion(y, x - 1);
    }
    public static int factorial (int n) {
        if (n == 1)
            return 1;
        return n * factorial(n-1);
    }
    public static void main(String[] args) {
//
//        ArrayList list = new ArrayList<>();
//        HashMap<String, String> capitalCities = new HashMap<String, String>();
//
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        System.out.println(capitalCities);



//        HashMap<Test, String> hashMap = new HashMap<Test, String>();
//        hashMap.put(new Test("a"), "employee1");
//        hashMap.put(new Test("b"), "employee2");
//        hashMap.put(new Test("a"), "employee1 overridden");
//
//        System.out.print(hashMap.size());
//        System.out.print(hashMap.get(new Test("a")));


//        System.out.println(recursion(2, 4));
//        Stack<Integer> myStack = new Stack<Integer>();
//        int n = 15937;
//        while (n > 0) {
//            myStack.push(n % 10);
//            n = n / 10;
//        }
//
//        while (!myStack.isEmpty()) {
//            System.out.print(myStack.pop() + " ");
//        }
//        System.out.println("\n");
//
//        Queue<String> queue = new LinkedList<String>();
//        queue.add("Ha Noi ");
//        queue.add("Hai Phong ");
//        queue.add("Da Nang ");
//        queue.add("TPHCM ");
//        queue.add("Can Tho ");
//        queue.peek();
//
//        System.out.print(queue.poll());
//        System.out.print(queue.peek());
//        System.out.print(queue.poll());
//
//        queue.poll();
//        queue.peek();
//
//        System.out.print(queue.poll());
//        System.out.print(queue.poll());

    }
}
