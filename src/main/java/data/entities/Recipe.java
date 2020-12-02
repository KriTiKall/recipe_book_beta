package data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import data.converters.RecipeTypeConverter;
import data.enums.RecipeType;
import lombok.Data;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Data
@Table(schema = "recipe_book",name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "id_user")
    private Integer idUser;
    @Convert(converter = RecipeTypeConverter.class)
    private RecipeType type;
    @Column(name = "manual", columnDefinition = "TEXT")
    private String manual;
    @Column
    private String difficulty;
    @Column
    private String time;
    @Column
    private String countServing;
}