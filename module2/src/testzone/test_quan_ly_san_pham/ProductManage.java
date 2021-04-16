package testzone.test_quan_ly_san_pham;

import java.util.ArrayList;
import java.util.List;

public class ProductManage {
    static int id=0;
    public static void main(String[] args) {
        List<Product> list=new ArrayList();
        list.add(new  Product(id,200,"Nam"));
    }


}
