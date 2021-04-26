package by.home.kitchen.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nameDish;

    private Date dateDish;
    private Integer wholeWeight;
    private Integer wholeCalories;
    private Integer wholeFats;
    private Integer wholeProteins;
    private Integer wholeCarbohydrates;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "dish", fetch = FetchType.LAZY)


    private Recipe recipe;
}
