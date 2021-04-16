package bai12_java_collectine_framework.bai_tap.quan_ly_san_pham2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManager extends Product {
    static int id = 1;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(id++, 900, "Apple"));
        productList.add(new Product(id++, 300, "Orange"));
        productList.add(new Product(id++, 400, "Banana"));
        int inPut;
        do {
            showMenu();
            inPut = scanner.nextInt();
            scanner.skip("\\R");
            switch (inPut) {
                case 1:
                    Product product1 = new Product();
                    product1.inPut();
                    productList.add(product1);
                    Product.disPlay((ArrayList) productList);
                    break;
                case 2:
                    Product.disPlay((ArrayList) productList);

//                    productList.forEach(e -> System.out.println(e));

//                    for (Product i: productList){
//                        System.out.println(i);
//                    }

                    break;
                case 3:
                    System.out.println("Nhập id cần sửa: ");
                    int enter = scanner.nextInt();
                    for (int i = 0; i < productList.size(); i++) {
                        if (enter == productList.get(i).getId()) {
                            System.out.println("Nhập giá cần sửa: ");
                            int editPrice = scanner.nextInt();
                            scanner.skip("\\R");
                            productList.get(i).setPrice(editPrice);

                            System.out.println("Nhập tên sản phẩm cần sửa: ");
                            String editName = scanner.nextLine();
                            productList.get(i).setName(editName);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nhập id cần xóa: ");
                    int enter1 = scanner.nextInt();
                    for (int i = 0; i < productList.size(); i++) {
                        if (enter1 == productList.get(i).getId()) {
                            productList.remove(productList.get(i));
                        }
                    }
                    Product.disPlay((ArrayList) productList);
                    break;
                case 5:
                    System.out.println("Nhập tên sản phẩm cần tìm: ");
                    String enter2 = scanner.nextLine();
                    for (int i = 0; i < productList.size(); i++) {
                        if (enter2.equals(productList.get(i).getName())) {
                            System.out.println(productList.get(i).toString());
                        }
                    }
                    break;
                case 6:
                    productList.sort(Comparator.comparing(Product::getPrice).reversed());
                    Product.disPlay((ArrayList) productList);
                    break;
                case 7:
                    System.out.println("Tạm biệt");
                    break;
                default:
                    System.out.println("Bạn nhập sai rồi, vui lòng nhập lại");
            }
        } while (inPut != 7);
    }
}