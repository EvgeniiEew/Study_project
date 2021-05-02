package by.home.kitchen.service.repository;

import by.home.kitchen.domain.Product;
import by.home.kitchen.domain.ProductLiquid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductLiquidJpaRepository extends JpaRepository<ProductLiquid, Integer> {
    Product getByIdAndInStockIsTrue(Integer id);

    List<Product> findAllByInStockIsTrue();

    Product findByName(String  name);

}
