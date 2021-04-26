package by.home.kitchen.service.repository;

import by.home.kitchen.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeJpaRepository extends JpaRepository<Recipe, Integer> {
}
