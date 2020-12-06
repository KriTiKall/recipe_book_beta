package logic;

import data.entities.Ingredient;
import data.entities.IngredientId;
import data.entities.Product;
import data.repositoryies.IngredientRepository;
import data.repositoryies.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private IngredientRepository repository;

    @Autowired
    public IngredientService(IngredientRepository repository) {
        this.repository = repository;
    }

    public Ingredient findById(Long idRecipe, Long idProduct) {
        return repository.getOne(new IngredientId(idRecipe, idProduct));
    }

    public List<Ingredient> findAll() {
        return repository.findAll();
    }

    public Ingredient add(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public void deleteById(Long idRecipe, Long idProduct) {
        repository.deleteById(new IngredientId(idRecipe, idProduct));
    }
}
