package by.home.kitchen.service.impl;

import by.home.kitchen.domain.ProductRecipe;
import by.home.kitchen.domain.Recipe;
import by.home.kitchen.service.IProductRecipeService;
import by.home.kitchen.service.IRecipeService;
import by.home.kitchen.service.repository.RecipeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class RecipeService implements IRecipeService {
    private final RecipeJpaRepository recipeJpaRepository;
    private final IProductRecipeService iProductRecipeService;

    @Override
    public List<Recipe> findAll() {
        return null;
    }

    @Override
    public void save(Recipe recipe) {
        List<ProductRecipe> productRecipes = iProductRecipeService.saveAll(recipe);
        recipe.setListProduct(productRecipes);
        recipeJpaRepository.save(recipe);
    }


    @Override
    public void save(List<Recipe> products) {

    }
}
