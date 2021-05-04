package demo_on_tap_product_manager.controller;

import demo_on_tap_product_manager.ProductService;
import demo_on_tap_product_manager.exception.IdNotFoundException;
import demo_on_tap_product_manager.model.Product;
import demo_on_tap_product_manager.service.impl.ProductServiceImpl;

import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);

    static ProductService productService = new ProductServiceImpl();

    public static void menu() {
        do {
            int id;
            System.out.println("1. Thêm\n" +
                    "2. Hiển thị\n" +
                    "3. Xoá\n" +
                    "4. Thoát");


            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    productService.addProduct();
                    break;

                case 2:
                    displayProduct();
                    break;
                case 3:
                    try {
                        System.out.println("Chọn id muốn xoá");
                        id = Integer.parseInt(scanner.nextLine());
                        productService.delete(id);
                    } catch (IdNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 4:
                    System.exit(0);
                    break;
                case 5:
                    try {
                        System.out.println("Chọn id muốn thay đổi");
                        id = Integer.parseInt(scanner.nextLine());
                        productService.change(id);
                    } catch (IdNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }


        } while (true);
    }

    public static void displayProduct() {
        for (Product product : productService.getAll()) {
            product.showInfor();
        }
    }

}
