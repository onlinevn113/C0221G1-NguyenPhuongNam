package bai10_dsa_danh_sach.thuc_hanh.lop_list_don_gian;

import java.util.LinkedList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // khai báo 1 danh sách liên kết
        // có kiểu là String
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Android");
        linkedList.add("iOS");
        linkedList.add("Windows Phone");

        System.out.println("Danh sách các phần tử trước khi thay đổi: ");
        System.out.print(linkedList + "\t");

        System.out.println("\nNhập vào chỉ số của phần tử cần thay đổi: ");
        int index = Integer.parseInt(scanner.nextLine());   // hạn chế hiện tượng trôi lệnh
        System.out.println("Nhập vào giá trị cần thay đổi: ");
        String str = scanner.nextLine();

        // kiểm tra nếu chỉ số lớn hơn hoặc bằng 0
        // và nhỏ hơn kích thước của linkedList - 1 thì mới cập nhật
        // ngược lại thông báo lỗi
        if ((index < 0) || (index > (linkedList.size() - 1))) {
            System.out.println("Chỉ số cần thay đổi phải lớn hơn 0 và nhỏ hơn "
                    + (linkedList.size()-1));
        } else {
            String node = linkedList.set(index, String.valueOf(str));
        }

        System.out.println("Danh sách các phần tử sau khi thay đổi: ");
        System.out.print(linkedList + "\t");
    }
}
