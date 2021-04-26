package by.home.kitchen.service.repository;

import by.home.kitchen.domain.ProductRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRecipeJpaRepository extends JpaRepository<ProductRecipe, Integer> {
}
