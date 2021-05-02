//package by.home.kitchen.service.impl;
//
//import by.home.kitchen.domain.Product;
//import by.home.kitchen.domain.ProductDto;
//import by.home.kitchen.service.IProductService;
//import by.home.kitchen.service.repository.ProductBulkJpaRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.core.convert.ConversionService;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//import java.util.List;
//
//@Transactional
//@Service
//@RequiredArgsConstructor
//public class ProductService implements IProductService {
//    private final ProductBulkJpaRepository productBulkJpaRepository;
//    private final ConversionService conversionService;
//
//    @Override
//    public List<Product> findAll() {
//        return productBulkJpaRepository.findAll();
//    }
//
//    @Override
//    public  String [] findNameProduct() {
//        List<Product> listProduct =  productBulkJpaRepository.findAll();
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
//            productBulkJpaRepository.save(conversionService.convert(productDto, Product.class));
//            return;
//        }
//        Product product = findByName(productDto.getName());
//        product.setWeight(product.getWeight() + productDto.getWeight());
//        productBulkJpaRepository.save(product);
//    }
//
//    public void editProduct(ProductDto productDto, Integer id) {
//        boolean inStock = false;
//        if (productDto.getWeight() > 0) {
//            inStock = true;
//        }
//        Product product = new Product(id, productDto.getName(), new Date(), productDto.getWeight(), productDto.getCalories(), productDto.getFats(), productDto.getProteins(), productDto.getCarbohydrates(), inStock);
//        productBulkJpaRepository.save(product);
//
//    }
//
//    @Override
//    public void save(List<Product> products) {
//        productBulkJpaRepository.saveAll(products);
//    }
//
//    @Override
//    public Product getAllProductDtoById(Integer id) {
//        return productBulkJpaRepository.getOne(id);
//    }
//
//    @Override
//    public Product getByIdAndInStockIsTrue(Integer id) {
//        return productBulkJpaRepository.getByIdAndInStockIsTrue(id);
//    }
//
//    @Override
//    public List<Product> findAllByInStockIsTrue() {
//        return productBulkJpaRepository.findAllByInStockIsTrue();
//    }
//
//    @Override
//    public Product findByName(String name) {
//        return productBulkJpaRepository.findByName(name);
//    }
//
//}
