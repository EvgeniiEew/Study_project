package by.home.kitchen.service.impl;

import by.home.kitchen.domain.Product;
import by.home.kitchen.domain.ProductRecipe;
import by.home.kitchen.domain.Recipe;
import by.home.kitchen.domain.RecipeDto;
import by.home.kitchen.service.IProductRecipeService;
import by.home.kitchen.service.IProductService;
import by.home.kitchen.service.IRecipeService;
import by.home.kitchen.service.repository.RecipeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class RecipeService implements IRecipeService {
    private final RecipeJpaRepository recipeJpaRepository;
    private final IProductService iProductService;
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
//    public List<RecipeDto> dishesCanCook2() {
//        List<RecipeDto> recipeDtoList = new ArrayList<>();
//        List<Recipe> recipesList = recipeJpaRepository.findAll();
//
//    }
    @Override
    public List<RecipeDto> dishesCanCook() {
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        List<Recipe> recipesList = recipeJpaRepository.findAll();
        List<Product> productDb = iProductService.findAll();
        for (Recipe recipe : recipesList) {
            RecipeDto recipeDto = new RecipeDto();
            createRecipeDto(recipe, recipeDto);
            for (ProductRecipe productRecipe : recipe.getListProduct()) {
             Optional<Product> product =  productDb.stream().filter(u-> u.getName().equals(productRecipe.getName())).findFirst();
                recipeDto.setCountDish( product.get().getWeight()/ productRecipe.getWeight());
            }
            recipeDtoList.add(recipeDto);
        }
        return recipeDtoList;
    }

    private void createRecipeDto(Recipe recipe, RecipeDto recipeDto) {

        recipeDto.setIdRecipe(recipe.getId());
        recipeDto.setNameRecipe(recipe.getNameRecipe());
        recipeDto.setRecipeList(recipe.getListProduct());
    }
}
