package logic;

import data.entities.Recipe;
import data.repositoryies.RecipeRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService implements logic.Service<Long, Recipe> {

    private RecipeRepository repository;

    @Autowired
    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Recipe findById(Long id) {
        Hibernate.initialize(repository.getOne(id));
        return repository.getOne(id);
    }

    @Override
    public List<Recipe> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Recipe> add(Recipe recipe) {
        repository.save(recipe);
        return findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
