package data.entities;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Embeddable
public class IngredientId implements Serializable {

    private Long idRecipe;
    private Long idProduct;

    public IngredientId() {
    }

    public IngredientId(Long idRecipe, Long idProduct) {
        this.idRecipe = idRecipe;
        this.idProduct = idProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientId that = (IngredientId) o;
        return Objects.equals(idRecipe, that.idRecipe) && Objects.equals(idProduct, that.idProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecipe, idProduct);
    }
}
