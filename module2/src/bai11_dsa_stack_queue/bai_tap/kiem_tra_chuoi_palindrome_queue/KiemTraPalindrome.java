package bai11_dsa_stack_queue.bai_tap.kiem_tra_chuoi_palindrome_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class KiemTraPalindrome {

    public static void main(String[] args) {
        Stack<Character> stack=new Stack();
        Queue<Character> queue=new LinkedList<>();
        String string="qwerewq";
        for (int i = 0; i <string.length() ; i++) {
            stack.push(string.charAt(i));
            queue.offer(string.charAt(i));
        }
        for (int i = 0; i <string.length() ; i++) {
            if (stack.pop()!=queue.remove()){
                System.out.println("k phải đối xứng");
                return;
            }
        }
        System.out.println("đối xứng");




//
//        Stack<String> stack1 = new Stack<>();
//        Queue<String> queue1 = new LinkedList<>();
//        String[] string1 = "abcdcbaa".split("");
//        for (int i = 0; i <string1.length ; i++) {
//            stack1.add(string1[i]);
//            queue1.add(string1[i]);
//        }
//        for (int i = 0; i < string1.length ; i++) {
//            if(!stack1.pop().equals(queue1.remove())){
//                System.out.println("khong phai la chuoi doi xung");
//                return;
//            }
//        }
//        System.out.println("la chuoi doi xung");

    }
}
