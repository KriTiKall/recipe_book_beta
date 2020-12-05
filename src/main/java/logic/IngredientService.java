package logic;

import data.entities.Ingredient;
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

    public Ingredient findById(long id) {
        return repository.getOne(id);
    }

    public List<Ingredient> findAllById(long id) {
        return repository.findAllById(List.of(id));
    }

    public List<Ingredient> findAll() {
        return repository.findAll();
    }

    public Ingredient add(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
