package controllers;

import data.entities.Ingredient;
import data.entities.IngredientId;
import logic.IngredientService;
import logic.Service;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class IngredientController {

    private final Service<IngredientId, Ingredient> service;

    @Autowired
    public IngredientController(Service<IngredientId, Ingredient> service) {
        this.service = service;
    }

    @GetMapping("/ingredients")
    public List<Ingredient> getIngredients() {
        return service.findAll();
    }

    @PostMapping("/ingredient/new")
    public List<Ingredient> create(@RequestBody Ingredient ingredient) {
        return service.add(ingredient);
    }

    @GetMapping("/ingredient/{idRecipe}/{idProduct}")
    public Ingredient getIngredient(@PathVariable Long idRecipe, @PathVariable Long idProduct) {
        return service.findById(new IngredientId(idRecipe, idProduct));
    }

    @PutMapping("/ingredient/{idRecipe}/{idProduct}")
    public List<Ingredient> update(@PathVariable Long idRecipe, @PathVariable Long idProduct, @RequestBody Ingredient ingredient) {
        return service.update(new IngredientId(idRecipe, idProduct), ingredient);
    }

    @DeleteMapping("/ingredient/{idRecipe}/{idProduct}")
    public void delete(@PathVariable Long idRecipe, @PathVariable Long idProduct) {
        service.deleteById(new IngredientId(idRecipe, idProduct));
    }
}
