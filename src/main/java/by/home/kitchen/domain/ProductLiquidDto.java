package by.home.kitchen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductLiquidDto {
    private Integer id;
    private String name;
    private Date date;
    private Integer calories;
    private Integer fats;
    private Integer proteins;
    private Integer carbohydrates;
    private boolean inStock;
    private Integer volume;
}
