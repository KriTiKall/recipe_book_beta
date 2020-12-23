package logic;

import data.entities.Ingredient;
import data.entities.IngredientId;
import data.repositoryies.IngredientRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService implements logic.Service<IngredientId, Ingredient> {

    private IngredientRepository repository;

    @Autowired
    public IngredientService(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Ingredient> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Ingredient> add(Ingredient ingredient) {
        repository.save(ingredient);
        return findAll();
    }

    @Override
    public Ingredient findById(IngredientId id) {
        Hibernate.initialize(repository.getOne(id));
        return repository.getOne(id);
    }

    @Override
    public void deleteById(IngredientId id) {
        repository.deleteById(id);
    }
}
