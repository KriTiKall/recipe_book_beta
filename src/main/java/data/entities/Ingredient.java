package data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Data
@Table(schema = "recipe_book",name = "ingredients")
@IdClass(IngredientId.class)
public class Ingredient {
    @Id
    @Column(name = "id_recipe")
    private Long idRecipe;
    @Id
    @Column(name = "id_prod")
    private Long idProduct;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "is_percent")
    private Boolean isPercent;
}