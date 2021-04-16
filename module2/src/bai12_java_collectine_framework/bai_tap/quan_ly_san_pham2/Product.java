package bai12_java_collectine_framework.bai_tap.quan_ly_san_pham2;

import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    private int id = 0;
    private int price;
    private String name;

    public Product() {
    }

    public Product(int id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    public void inPut() {
        Scanner scanner = new Scanner(System.in);
        id = ProductManager.id++;
        System.out.println("Nhập giá: ");
        price = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên: ");
        name = scanner.nextLine();
    }

    public static void showMenu() {
        System.out.println("1.Thêm sản phẩm: ");
        System.out.println("2.Hiển thị sản phẩm: ");
        System.out.println("3.Sửa thông tin sản phẩm: ");
        System.out.println("4.Xóa sản phẩm: ");
        System.out.println("5.Tìm kiếm sản phẩm theo tên: ");
        System.out.println("6.Sắp xếp sản phẩm tăng dần: ");
        System.out.println("7.Thoát: ");
    }

    public static  <T> void disPlay(ArrayList T) {
        T.forEach(e -> System.out.println(e));
    }
}
