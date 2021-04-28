package by.home.kitchen.service;

import by.home.kitchen.domain.Recipe;
import by.home.kitchen.domain.RecipeDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IRecipeService {
    Page<Recipe> findAllRecipeNative(int pageNo, int pageSize);

    List<Recipe> findAll();

    Optional<Recipe> findById(Integer id);

    void save(Recipe recipe);

    void save(List<Recipe> products);

    List<RecipeDto> dishesCanCook();
}
