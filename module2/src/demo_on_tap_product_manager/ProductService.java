package demo_on_tap_product_manager;

import demo_on_tap_product_manager.exception.IdNotFoundException;
import demo_on_tap_product_manager.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct();
    void delete(int id)throws IdNotFoundException;
    void change(int id)throws IdNotFoundException;
    List<Product> getAll();
}
