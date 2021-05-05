package by.home.kitchen.service;

import by.home.kitchen.domain.ProductPieceDto;

import java.util.List;

public interface IProductPieceService {
    List<ProductPieceDto> findAll();
}
