package ra.bai1.repository;

import konta.bai1.model.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    boolean save(Product product);
    Product findById(Integer id);
    boolean update(Product product);
}
