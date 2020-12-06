package view;

import data.entities.Product;
import data.entities.Recipe;
import logic.ProductService;
import logic.RecipeService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class RecipeController {

    private final RecipeService service;

    @Autowired
    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @GetMapping("/recipes")
    public List<Recipe> getRecipes() {
        return service.findAll();
    }

    @GetMapping("/recipe/{id}")
    public Recipe getRecipe(@PathVariable Long id) {
        Hibernate.initialize(service.findById(id));
        return service.findById(id);
    }

    @PostMapping("/recipe/new")
    public List<Recipe> create(@RequestBody Recipe recipe) {
        service.add(recipe);
        return service.findAll();
    }

    @PutMapping("/recipe/{id}")
    public List<Recipe> update(@PathVariable Long id, @RequestBody Recipe recipe) {
        //todo entering id to request body is optional
        if (service.findById(id) != null)
            service.add(recipe);
        return service.findAll();
    }

    @DeleteMapping("/recipe/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
