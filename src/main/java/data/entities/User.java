package data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Data
@Table(schema = "recipe_book",name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String mail;
}
