package data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import data.enums.ProductType;
import lombok.Data;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Data
@Table(schema = "recipe_book", name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
//    @Convert(converter = ProductTypeConverter.class)
//    @Column(columnDefinition = "product_type")
//    @Type( type = "pgsql_enum" )
    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "recipe_book.product_type")
    private ProductType type;
}
