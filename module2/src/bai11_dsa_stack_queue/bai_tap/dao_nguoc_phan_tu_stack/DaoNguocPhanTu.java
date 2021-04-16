package bai11_dsa_stack_queue.bai_tap.dao_nguoc_phan_tu_stack;

import java.util.ArrayList;
import java.util.Stack;

public class DaoNguocPhanTu {
    private static void DaoNguocMang(ArrayList<Integer> list) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = list.size(); i >0 ; i--) {
            stack.push(list.remove(0));
        }
        for (int i =stack.size(); i >0 ; i--) {
            list.add(stack.pop());
        }
        System.out.println("Sau " + list);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println("Trước " + list);
        DaoNguocMang(list);
    }


}
