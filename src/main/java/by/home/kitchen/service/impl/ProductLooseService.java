package by.home.kitchen.service.impl;

import by.home.kitchen.domain.ProductLoose;
import by.home.kitchen.domain.ProductLooseDto;
import by.home.kitchen.service.IProductLooseService;
import by.home.kitchen.service.repository.ProductLooseJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class ProductLooseService implements IProductLooseService {

    private final ProductLooseJpaRepository productLooseJpaRepository;

    @Override
    public List<ProductLooseDto> findAll() {
        List<ProductLoose> productLooses = productLooseJpaRepository.findAll();
        return productLooses.stream().map(ProductLoose ->
                new ProductLooseDto(
                        ProductLoose.getId(),
                        ProductLoose.getName(),
                        ProductLoose.getDate(),
                        ProductLoose.getCalories(),
                        ProductLoose.getFats(),
                        ProductLoose.getProteins(),
                        ProductLoose.getCarbohydrates(),
                        ProductLoose.isInStock(),
                        ProductLoose.getWeight()
                )).collect(Collectors.toList());
    }
    }
