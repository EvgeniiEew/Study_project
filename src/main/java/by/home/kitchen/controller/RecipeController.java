package by.home.kitchen.controller;

import by.home.kitchen.domain.Product;
import by.home.kitchen.domain.ProductRecipe;
import by.home.kitchen.domain.Recipe;
import by.home.kitchen.service.IProductService;
import by.home.kitchen.service.IRecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class RecipeController {
    private final IProductService iProductService;
    private final IRecipeService iRecipeService;
    private final String LIST_OF_RECIPE = "RecipeList";
    private final String LIST_OF_RECIPE_Add = "RecipeAddList";
    private final String LIST_OF_ADD_RECIPE_COUNT = "RecipeCountList";

    @GetMapping("/recipe/counting")
    public String getCountSelector(Model model) {
        return LIST_OF_ADD_RECIPE_COUNT;
    }

    @GetMapping("/recipe/add")
    public String addRecipe(@RequestParam  String nameRecipe,Integer count, Model model) {
        List<ProductRecipe> products = IntStream.range(0, count).mapToObj(i -> new ProductRecipe()).collect(Collectors.toList());
        model.addAttribute("ProductDb" ,iProductService.findNameProduct());
        model.addAttribute("ProductRecipe",new Recipe(products, nameRecipe));
        return LIST_OF_RECIPE_Add;
    }

    @PostMapping("/recipe/{nameRecipe}/add")
    public String saveRecipe(@ModelAttribute Recipe recipe, @PathVariable("nameRecipe")  String nameRecipe, Model model ) {
        System.out.println(recipe);
        recipe.setNameRecipe(nameRecipe);
        iRecipeService.save(recipe);
        return LIST_OF_RECIPE;
    }

}
