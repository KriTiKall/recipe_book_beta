package data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Data
@Table(schema = "recipe_book",name = "ingredients")
public class Ingredient implements EntityWithId<IngredientId>{
    @EmbeddedId
    private IngredientId id;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "is_percent")
    private Boolean isPercent;
}