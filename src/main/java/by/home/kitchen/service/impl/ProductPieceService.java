package by.home.kitchen.service.impl;

import by.home.kitchen.domain.ProductPiece;
import by.home.kitchen.domain.ProductPieceDto;
import by.home.kitchen.service.IProductPieceService;
import by.home.kitchen.service.repository.ProductPieceJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class ProductPieceService implements IProductPieceService {
    private final ProductPieceJpaRepository productPieceJpaRepository;

    @Override
    public List<ProductPieceDto> findAll() {
        List<ProductPiece> productPieces = productPieceJpaRepository.findAll();
        return productPieces.stream().map(ProductPiece ->
                new ProductPieceDto(
                        ProductPiece.getId(),
                        ProductPiece.getName(),
                        ProductPiece.getDate(),
                        ProductPiece.getCalories(),
                        ProductPiece.getFats(),
                        ProductPiece.getProteins(),
                        ProductPiece.getCarbohydrates(),
                        ProductPiece.isInStock(),
                        ProductPiece.getWeight(),
                        ProductPiece.getCount()
                )).collect(Collectors.toList());
    }
}
