package by.home.kitchen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Product {

    private String name;
    private Date date;

    private Integer calories;
    private Integer fats;
    private Integer proteins;
    private Integer carbohydrates;
    private boolean inStock;

}
