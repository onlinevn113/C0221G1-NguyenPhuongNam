package bai12_java_collectine_framework.bai_tap.quan_ly_san_pham;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SettingMethod {
    static List<ProductsManage> products=new ArrayList<>();
    Scanner scanner=new Scanner(System.in);
    public static void add(ProductsManage product){
        products.add(product);
    }
    public static void edit(int id){
        for (ProductsManage i: products) {
            if (i.getId()==id){
                i.setId(1);
                i.setName("Nam");
                i.setPrice(300);
                return;
            }
        }
    }
    public static ProductsManage delete(int id){
       for (ProductsManage i:products){
           if (i.getId()==id){
               products.remove(i);
               return i;
           }
       }return null;
    }
    public static void disPlay(){
        System.out.println("List Produsts: ");
        for (ProductsManage i:products){
            System.out.println(i);
        }
    }
    public static void sort(){
        Comparator<ProductsManage> comparator=new Comparator<ProductsManage>() {
            @Override
            public int compare(ProductsManage o1, ProductsManage o2) {
            if (o1.getId()-o2.getId()!=0){
                return o1.getId()-o2.getId();
            }else {
                return (int) (o1.getPrice()-o2.getPrice());
            }
            }
        };
        products.sort(comparator);
    }


}
