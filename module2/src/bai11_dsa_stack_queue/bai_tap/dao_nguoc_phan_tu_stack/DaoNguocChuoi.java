package bai11_dsa_stack_queue.bai_tap.dao_nguoc_phan_tu_stack;

import java.util.Stack;

public class DaoNguocChuoi {
    private static void DaoNguocChuoi(String string) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < string.length(); i++) {
        stack.push(string.charAt(i));
    }
    StringBuilder stringBuilder = new StringBuilder();
    int size = stack.size();
    for (int i = 0; i < size; i++) {
        stringBuilder.append(stack.pop());
    }
    System.out.println("Chuối đảo ngược là: "+stringBuilder);

}
    public static void main(String[] args) {
        String string = "Nam123 Nam456 Nam789";
        System.out.println("Chuỗi ban đầu là: "+string);
        DaoNguocChuoi(string);

    }


}
