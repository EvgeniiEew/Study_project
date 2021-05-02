package by.home.kitchen.service.repository;

import by.home.kitchen.domain.ProductPiece;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPieceJpaRepository extends JpaRepository<ProductPiece, Integer> {
}
