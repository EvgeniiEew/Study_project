package by.home.kitchen.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private Date date;
    private Integer weight;
    private Integer calories;
    private Integer fats;
    private Integer proteins;
    private Integer carbohydrates;
    private boolean inStock;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
}
