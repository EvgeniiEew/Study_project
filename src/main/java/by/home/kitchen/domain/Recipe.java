package by.home.kitchen.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nameRecipe;

    @OneToMany(mappedBy = "recipe")
    private List<ProductRecipe> listProduct;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dish_id", referencedColumnName = "id")
    private Dish dish;

    public Recipe(List<ProductRecipe> productRecipes, String nameRecipe) {
        this.nameRecipe = nameRecipe;
        this.listProduct = productRecipes;
    }
}
