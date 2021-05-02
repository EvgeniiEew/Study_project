//package by.home.kitchen.service.impl;
//
//import by.home.kitchen.domain.Product;
//import by.home.kitchen.domain.ProductRecipe;
//import by.home.kitchen.domain.Recipe;
//import by.home.kitchen.service.IProductRecipeService;
//import by.home.kitchen.service.IProductService;
//import by.home.kitchen.service.repository.ProductRecipeJpaRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Transactional
//@Service
//@RequiredArgsConstructor
//public class ProductRecipeService implements IProductRecipeService {
//    private final ProductRecipeJpaRepository productRecipeJpaRepository;
//    private final IProductService iProductService;
//
//
//    @Override
//    public List<ProductRecipe> saveAll(Recipe recipe) {
//        List<ProductRecipe> productRecipes = recipe.getListProduct();
//        for (ProductRecipe productRecipe : productRecipes) {
//            Product product = iProductService.findByName(productRecipe.getName());
//            productRecipe.setCalories((productRecipe.getWeight() * product.getCalories()) / 100);
//            productRecipe.setFats((productRecipe.getWeight() * product.getFats()) / 100);
//            productRecipe.setProteins((productRecipe.getWeight() * product.getProteins()) / 100);
//            productRecipe.setCarbohydrates((productRecipe.getWeight() * product.getCarbohydrates()) / 100);
//            productRecipe.setRecipe(recipe);
//
//        }
//        productRecipeJpaRepository.saveAll(productRecipes);
//        return productRecipes;
//    }
//}
