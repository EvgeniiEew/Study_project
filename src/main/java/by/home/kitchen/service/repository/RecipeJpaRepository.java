package by.home.kitchen.service.repository;

import by.home.kitchen.domain.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RecipeJpaRepository extends JpaRepository<Recipe, Integer> {
    Page<Recipe> findAllByIdIn(List<Integer> list, Pageable pageable);

    Optional<Recipe> findById(Integer id);

    @Query(value = "select id from recipe", nativeQuery = true)
    List<Integer> findAllActiveRecipeNative();
    Recipe existsByNameRecipe(String name);
}
