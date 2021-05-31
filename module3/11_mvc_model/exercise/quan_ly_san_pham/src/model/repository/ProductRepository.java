package model.repository;

import model.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    static Map<String, Product> productMap = new HashMap<>();

    static {
        productMap.put("1", new Product("1", "SamSung", "200"));
        productMap.put("2", new Product("2", "Iphone", "300"));
        productMap.put("3", new Product("3", "Oppo", "400"));
    }


    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public List<Product> findByName(String name) {
        name.trim();
        List<Product> productList=new ArrayList<>();
      for (Product product:productMap.values()){
          if (product.getName().contains(name)){
              productList.add(product);
          }
      }
        return productList;
    }

    public Product findById(String id) {
        return productMap.get(id);
    }

    public void create(Product product) {
        productMap.put(product.getId(), product);
    }

    public void update(String id, Product product) {
        productMap.put(id, product);
    }

    public void delete(String id) {
        productMap.remove(id);
    }


}
