package data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import data.enums.PostgresEnumType;
import data.enums.RecipeType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Data
@Table(schema = "recipe_book",name = "recipes")
@TypeDef(name = "pgsql_enum",
        typeClass = PostgresEnumType.class)
public class Recipe implements EntityWithId<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_user")
    private Long idUser;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "recipe_book.product_type")
    @Type(type = "pgsql_enum")
    private RecipeType type;
    @Column(name = "manual", columnDefinition = "TEXT")
    private String manual;
    @Column
    private String difficulty;
    @Column
    private String time;
    @Column(name = "count_serving")
    private String countServing;
}