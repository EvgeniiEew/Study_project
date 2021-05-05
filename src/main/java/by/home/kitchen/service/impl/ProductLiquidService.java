package by.home.kitchen.service.impl;

import by.home.kitchen.domain.*;
import by.home.kitchen.service.IProductLiquidService;
import by.home.kitchen.service.repository.ProductLiquidJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class ProductLiquidService implements IProductLiquidService {
    private final ProductLiquidJpaRepository productLiquidJpaRepository;

    private final ConversionService conversionService;

    @Override
    public List<ProductLiquidDto> findAll() {
        List<ProductLiquid> productLiquids = productLiquidJpaRepository.findAll();
        return productLiquids.stream().map(ProductLiquid ->
                new ProductLiquidDto(
                        ProductLiquid.getId(),
                        ProductLiquid.getName(),
                        ProductLiquid.getDate(),
                        ProductLiquid.getCalories(),
                        ProductLiquid.getFats(),
                        ProductLiquid.getProteins(),
                        ProductLiquid.getCarbohydrates(),
                        ProductLiquid.isInStock(),
                        ProductLiquid.getVolume()
                )).collect(Collectors.toList());
    }

//    @Override
//    public  String [] findNameProduct() {
//        List<ProductLiquid> listProduct =  productLiquidJpaRepository.findAll();
//        int number = 0;
//       String [] nameProduct = new String[listProduct.size()];
//
//        for(Product products : listProduct){
//            nameProduct [number] = products.getName();
//            number++;
//        }
//        return nameProduct;
//    }
//
//    @Override
//    public void save(ProductDto productDto) {
//        if (findByName(productDto.getName()) == null) {
//            productLiquidJpaRepository.save(conversionService.convert(productDto, Product.class));
//            return;
//        }
//        Product product = findByName(productDto.getName());
//        product.setWeight(product.getWeight() + productDto.getWeight());
//        productLiquidJpaRepository.save(product);
//    }
//
//    public void editProduct(ProductDto productDto, Integer id) {
//        boolean inStock = false;
//        if (productDto.getWeight() > 0) {
//            inStock = true;
//        }
//        Product product = new ProductLiquid(id, productDto.getName(), new Date(), productDto.getWeight(), productDto.getCalories(), productDto.getFats(), productDto.getProteins(), productDto.getCarbohydrates(), inStock);
//        productLiquidJpaRepository.save(product);
//
//    }
//
//    @Override
//    public void save(List<ProductLiquid> productLiquids) {
//        productLiquidJpaRepository.saveAll(productLiquids);
//    }
//
//    @Override
//    public ProductLiquid getAllProductDtoById(Integer id) {
//        return productLiquidJpaRepository.getOne(id);
//    }
//
//    @Override
//    public ProductLiquid getByIdAndInStockIsTrue(Integer id) {
//        return productLiquidJpaRepository.getByIdAndInStockIsTrue(id);
//    }
//
//    @Override
//    public List<ProductLiquid> findAllByInStockIsTrue() {
//        return productLiquidJpaRepository.findAllByInStockIsTrue();
//    }
//
//    @Override
//    public ProductLiquid findByName(String name) {
//        return productLiquidJpaRepository.findByName(name);
//    }

}
