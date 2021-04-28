package by.home.kitchen.service.impl;

import by.home.kitchen.domain.ProductRecipe;
import by.home.kitchen.domain.Recipe;
import by.home.kitchen.service.IProductRecipeService;
import by.home.kitchen.service.IRecipeService;
import by.home.kitchen.service.repository.RecipeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class RecipeService implements IRecipeService {
    private final RecipeJpaRepository recipeJpaRepository;
    private final IProductRecipeService iProductRecipeService;

    @Override
    public List<Recipe> findAll() {
        return recipeJpaRepository.findAll();
    }

    @Override
    public Optional<Recipe> findById(Integer id) {
        return recipeJpaRepository.findById(id);
    }

    @Override
    public Page<Recipe> findAllRecipeNative(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return recipeJpaRepository.findAllByIdIn(recipeJpaRepository.findAllActiveRecipeNative(), pageable);
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
