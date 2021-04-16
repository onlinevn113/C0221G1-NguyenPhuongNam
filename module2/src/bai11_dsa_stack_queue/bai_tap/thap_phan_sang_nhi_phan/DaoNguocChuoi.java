package bai11_dsa_stack_queue.bai_tap.thap_phan_sang_nhi_phan;

import java.util.Stack;

public class DaoNguocChuoi {
    public static void reverse(StringBuilder string) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder);


    }
}
