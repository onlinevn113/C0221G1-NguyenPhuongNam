package testzone;

import sun.net.www.content.text.Generic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class TestStackQueueGeneric {
    public static void main(String[] args) {
        //Stack
        Stack stack = new Stack();
        stack.push(1);
        stack.pop();
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.push(4);
        stack.push(5);
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }



        //Queue

    }
}
