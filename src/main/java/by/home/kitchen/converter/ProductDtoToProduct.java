package by.home.kitchen.converter;

import by.home.kitchen.domain.ProductDto;
import by.home.kitchen.domain.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class ProductDtoToProduct implements Converter<ProductDto, Product> {
    @Override
    public Product convert(ProductDto productDto) {
        Product product = new Product(null,
                productDto.getName(),
                new Date(),
                productDto.getWeight(),
                productDto.getCalories(),
                productDto.getFats(),
                productDto.getProteins(),
                productDto.getCarbohydrates(), true);
        return product;
    }
}
