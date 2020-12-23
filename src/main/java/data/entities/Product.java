package data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import data.enums.PostgresEnumType;
import data.enums.ProductType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Data
@Table(schema = "recipe_book", name = "products")
@TypeDef(name = "pgsql_enum",
        typeClass = PostgresEnumType.class)
public class Product implements EntityWithId<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "recipe_book.product_type")
    @Type(type = "pgsql_enum")
    private ProductType type;
}
