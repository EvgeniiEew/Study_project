package by.home.kitchen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private String name;
    private Integer weight;
    private Integer calories;
    private Integer fats;
    private Integer proteins;
    private Integer carbohydrates;
}
