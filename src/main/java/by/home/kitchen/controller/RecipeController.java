//package by.home.kitchen.controller;
//
//import by.home.kitchen.domain.ProductRecipe;
//import by.home.kitchen.domain.Recipe;
//import by.home.kitchen.domain.RecipeDto;
//import by.home.kitchen.service.IProductService;
//import by.home.kitchen.service.IRecipeService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//@Controller
//@RequiredArgsConstructor
//public class RecipeController {
//    private final int pageSize = 5;
//    private final IProductService iProductService;
//    private final IRecipeService iRecipeService;
//    private final String LIST_OF_RECIPE = "RecipeList";
//    private final String LIST_OF_RECIPE_ADD = "RecipeAddList";
//    private final String LIST_OF_ADD_RECIPE_COUNT = "RecipeCountList";
//    private final String LIST_OF_RECIPE_CAN_COOK = "recipeCanCookList";
//
//    @GetMapping("/recipe/counting")
//    public String getCountSelector(Model model) {
//        return LIST_OF_ADD_RECIPE_COUNT;
//    }
//
//    @GetMapping("/recipe/add")
//    public String addRecipe(@RequestParam String nameRecipe, Integer count, Model model) {
//        List<ProductRecipe> products = IntStream.range(0, count).mapToObj(i -> new ProductRecipe()).collect(Collectors.toList());
//        model.addAttribute("ProductDb", iProductService.findNameProduct());
//        model.addAttribute("ProductRecipe", new Recipe(products, nameRecipe));
//        return LIST_OF_RECIPE_ADD;
//    }
//
//    @PostMapping("/recipe/{nameRecipe}/add")
//    public String saveRecipe(@ModelAttribute Recipe recipe, @PathVariable("nameRecipe") String nameRecipe, Model model) {
//        System.out.println(recipe);
//        recipe.setNameRecipe(nameRecipe);
//        iRecipeService.save(recipe);
//        return "redirect:/recipe/list";
//    }
//
//    @GetMapping("/recipe/list")
//    public String getRecipeList(Model model) {
//        return recipeFindPaginated(1, model);
//    }
//
//
//    @GetMapping("/recipe/list/{pageNo}")
//    public String recipeFindPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
//        Page<Recipe> recipesPage = iRecipeService.findAllRecipeNative(pageNo, pageSize);
//        List<Recipe> recipesList = recipesPage.getContent();
//        model.addAttribute("currentPage", pageNo);
//        model.addAttribute("totalPages", recipesPage.getTotalPages());
//        model.addAttribute("totalItems", recipesPage.getTotalElements());
//        model.addAttribute("recipesList", recipesList);
//        return LIST_OF_RECIPE;
//    }
//
//    @GetMapping("/recipe/canCook/list")
//    public String getRecipeCanCookList(Model model) {
//        model.addAttribute("recipeDtoList", iRecipeService.dishesCanCook());
//        return LIST_OF_RECIPE_CAN_COOK;
//    }
//    @PostMapping("/recipe/cook/{count}")
//    public String cookDish(@PathVariable(value = "count")  Integer count){
//        return null;
//    }
//
//
////    @GetMapping("/recipe/edit/{id}")
////    public String recipeEdit(@PathVariable(value = "id") Integer id, Model model) {
////        Optional<Recipe> recipe =  iRecipeService.findById(id);
////        List<ProductRecipe> listProduct = recipe.get().getListProduct();
////        model.addAttribute("Recipe",recipe);
////        model.addAttribute("ListProducts",listProduct);
////    }
//}
