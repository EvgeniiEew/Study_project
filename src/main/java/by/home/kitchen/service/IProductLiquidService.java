package by.home.kitchen.service;

import by.home.kitchen.domain.ProductLiquid;
import by.home.kitchen.domain.ProductLiquidDto;

import java.util.List;

public interface IProductLiquidService {
    List<ProductLiquidDto> findAll();

//    String[] findNameProduct();
//
//    void save(ProductDto product);
//
//    void save(List<ProductLiquid> products);
//
//    ProductLiquid getAllProductDtoById(Integer id);
//
//    void editProduct(ProductDto productDto, Integer id);
//
//    ProductLiquid getByIdAndInStockIsTrue(Integer id);
//
//    List<ProductLiquid> findAllByInStockIsTrue();
//
//    ProductLiquid findByName(String name);
}
