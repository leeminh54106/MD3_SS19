package ra.bai1.service;

import konta.bai1.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    boolean save(Product product);
    Product findById(Integer id);
    boolean update(Product product);
}
