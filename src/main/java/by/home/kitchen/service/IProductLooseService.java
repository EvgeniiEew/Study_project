package by.home.kitchen.service;

import by.home.kitchen.domain.ProductLooseDto;

import java.util.List;

public interface IProductLooseService {
    List<ProductLooseDto> findAll();
}
