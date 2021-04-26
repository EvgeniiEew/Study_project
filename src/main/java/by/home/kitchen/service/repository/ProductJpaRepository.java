package by.home.kitchen.service.repository;

import by.home.kitchen.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductJpaRepository extends JpaRepository<Product, Integer> {
    Product getByIdAndInStockIsTrue(Integer id);

    List<Product> findAllByInStockIsTrue();

    Product findByName(String  name);

}
