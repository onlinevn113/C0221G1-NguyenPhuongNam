package bai17_.ztest;

import java.io.*;
import java.util.Scanner;

public class IO_Product {
    public static void main(String args[]) throws Exception {
        ProcessProduct ps = new ProcessProduct();   // tao doi tuong cua lop ProcessProduct
        Product[] product1 = null;
        product1 = ps.create();  // nhap product
        ps.write(product1);     // viet vao file
        Product[] product2 = null;
        product2 = ps.read();   // doc tu file
        ps.show(product2);      //hien thi kq
    }

    static class Product implements Serializable {
        private int id;
        private String name;
        private String brand;
        private double money;
        private String desc;

        public Product() {
        }

        public Product(int id, String name, String brand, double money, String desc) {
            this.id = id;
            this.name = name;
            this.brand = brand;
            this.money = money;
            this.desc = desc;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    static class ProcessProduct {

        public Product[] create() {      // Input the data from Keyboard
            int n;
            Scanner scan = new Scanner(System.in);

            System.out.print("Enter number of Product: ");
            n = Integer.parseInt(scan.nextLine());  //nhap so luong

            Product[] Product = new Product[n];

            for (int i = 0; i < n; i++) {
                System.out.println("Enter id:");
                int id = Integer.parseInt(scan.nextLine());
                System.out.print("Enter name: ");   // nhap ten
                String name = scan.nextLine();
                System.out.print("Enter brand: ");   // nhap hang
                String brand = scan.nextLine();
                System.out.print("Enter money: ");    // nhap tien
                double money = Double.parseDouble(scan.nextLine());    // tranh troi lenh nhu khi dung scan.nextDouble()
                System.out.print("Enter desc: ");   // nhap ten
                String desc = scan.nextLine();
                Product[i] = new Product(id, name, brand, money, desc);    // khoi tao doi tuong Product thu i
            }

            scan.close();
            return Product;
        }

        public void write(Product[] product) {  //ghi theo Object
            FileOutputStream f = null;
            ObjectOutputStream oStream = null;
            try {   // dat try cacth de tranh ngoai le khi tao va ghi File
                f = new FileOutputStream("E:\\C0221G1-NguyenPhuongNam\\module2\\src\\bai17_\\ztest\\Product.txt");   // tao file f tro den Product.dat
                oStream = new ObjectOutputStream(f); // dung de ghi theo Object vao file f
                oStream.writeObject(product);   // ghi Product theo kieu Object vao file
            } catch (IOException e) {
                System.out.println("Error Write file");
            } finally {
                try {
                    oStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public Product[] read() {       // doc theo Object
            Product[] Product = null;
            ObjectInputStream inStream = null;
            FileInputStream f = null;
            try {   // dat try cacth de tranh ngoai le khi tao va doc File
                f = new FileInputStream("E:\\C0221G1-NguyenPhuongNam\\module2\\src\\bai17_\\ztest\\Product.txt"); // tao file f tro den Product.dat
                inStream = new ObjectInputStream(f);  // dung de doc theo Object vao file f
                // dung inStream doc theo Object, ep kieu tra ve la Product
                Product = (Product[]) inStream.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found");
            } catch (IOException e) {
                System.out.println("Error Read file");
            } finally {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return Product;
        }

        public void show(Product[] product) throws Exception {      //In data doc duoc tu file ra man hinh
            try {
                for (int i = 0; i < product.length; i++) {
                    System.out.println((i + 1) + " :\n" +
                            " Product id is: " + product[i].getId() +
                            "\n Product name is: " + product[i].getName() +
                            "\n Product brand is: " + product[i].getBrand() +
                            "\n Product money is:" + product[i].getMoney() +
                            "\n Product desc is:" + product[i].getDesc());
                }
            } catch (NullPointerException e) {
                System.out.println("File Empty");
            }
        }
    }
}