package demo_on_tap_product_manager.service.impl;

import demo_on_tap_product_manager.ProductService;
import demo_on_tap_product_manager.exception.IdNotFoundException;
import demo_on_tap_product_manager.model.Product;


import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void addProduct() {
        List<Product> productList = FuncWriteAndReadFile.readFile("product.csv");
        int id = 0;
        if (productList.isEmpty()) {
            id = 1;
        } else {
            id = productList.get(productList.size() - 1).getId() + 1;
        }
        System.out.println("Nhập tên sản phẩm");
        String name = scanner.nextLine();

        System.out.println("Nhập mô tả");
        String amount = scanner.nextLine();


        productList.add(new Product(id, name, amount));
        FuncWriteAndReadFile.writeFile("product.csv", productList, false);
    }

    @Override
    public void delete(int id) throws IdNotFoundException {
        boolean idNotFound = true;
        List<Product> productList = FuncWriteAndReadFile.readFile("product.csv");
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                productList.remove(productList.get(i));
                idNotFound = false;
                break;
            }
        }
        if (idNotFound) {
            throw new IdNotFoundException("Id not found");
        } else {
            FuncWriteAndReadFile.writeFile("product.csv", productList, false);
        }

    }

    public void change(int id) throws IdNotFoundException {
        boolean idNotFound = true;
        List<Product> productList = FuncWriteAndReadFile.readFile("product.csv");
        for (Product product : productList) {
            if (product.getId() == id) {

                System.out.println("Nhập tên muốn sửa");
                String name = scanner.nextLine();
                System.out.println("Nhập amount muốn sửa");
                String amount = scanner.nextLine();
                product.setName(name);
                product.setAmount(amount);
                idNotFound = false;
                break;
            }
        }
        if (idNotFound) {
            throw new IdNotFoundException("Id not found");
        }
        FuncWriteAndReadFile.writeFile("product.csv", productList, false);
    }
   
    @Override
    public List<Product> getAll() {
        return FuncWriteAndReadFile.readFile("product.csv");

    }
}
