package data.repositoryies;

import data.entities.Ingredient;
import data.entities.IngredientId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, IngredientId> {
}
