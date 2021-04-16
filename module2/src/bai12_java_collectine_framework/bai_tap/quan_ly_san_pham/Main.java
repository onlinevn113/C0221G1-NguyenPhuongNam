package bai12_java_collectine_framework.bai_tap.quan_ly_san_pham;

import static bai12_java_collectine_framework.bai_tap.quan_ly_san_pham.SettingMethod.*;


public class Main {
    public static void main(String[] args) {
        ProductsManage product1=new ProductsManage("Phương",7,200);
        ProductsManage product2=new ProductsManage("Nguyễn",3,400);
        ProductsManage product3=new ProductsManage("PNam",3,500);
        ProductsManage product4=new ProductsManage("NPNam",3,100);
        add(product1);
        add(product2);
        add(product3);
        add(product4);
        delete(7);
        disPlay();



    }
}
