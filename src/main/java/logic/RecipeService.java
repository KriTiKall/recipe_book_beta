package logic;

import data.entities.Product;
import data.entities.Recipe;
import data.repositoryies.ProductRepository;
import data.repositoryies.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private RecipeRepository repository;

    @Autowired
    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public Recipe findById(long id) {
        return repository.getOne(id);
    }

    public List<Recipe> findAll() {
        return repository.findAll();
    }

    public Recipe add(Recipe recipe) {
        return repository.save(recipe);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
