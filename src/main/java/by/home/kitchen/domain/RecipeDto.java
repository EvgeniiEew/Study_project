package by.home.kitchen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {
    private Integer idRecipe;
    private String nameRecipe;
    private List<ProductRecipe> recipeList;
    private Integer countDish;

}
