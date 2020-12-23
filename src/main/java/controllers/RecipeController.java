package controllers;

import data.entities.Recipe;
import logic.RecipeService;
import logic.Service;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class RecipeController {

    private final Service<Long, Recipe> service;

    @Autowired
    public RecipeController(Service<Long, Recipe> service) {
        this.service = service;
    }

    @GetMapping("/recipes")
    public List<Recipe> getRecipes() {
        return service.findAll();
    }

    @PostMapping("/recipe/new")
    public List<Recipe> create(@RequestBody Recipe recipe) {
        return service.add(recipe);
    }

    @GetMapping("/recipe/{id}")
    public Recipe getRecipe(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/recipe/{id}")
    public List<Recipe> update(@PathVariable Long id, @RequestBody Recipe recipe) {
        return service.update(id, recipe);
    }

    @DeleteMapping("/recipe/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
