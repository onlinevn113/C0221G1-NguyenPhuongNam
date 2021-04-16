package bai11_dsa_stack_queue.bai_tap.kiem_tra_dau_ngoac_stack;

import java.util.Stack;

public class KiemTraDauNgoac {
    public static void main(String[] args) {
        Stack<Character> bStack = new Stack();
        String string = ")))";
        KiemTraDauNgoac(bStack, string);

    }

    private static void KiemTraDauNgoac(Stack<Character> bStack, String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                bStack.push(string.charAt(i));
            }
            if (string.charAt(i) == ')') {
                if (bStack.isEmpty()) {
                    System.out.println("false");
                    return;
                }
                bStack.pop();
            }

        }
        if (bStack.isEmpty()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
