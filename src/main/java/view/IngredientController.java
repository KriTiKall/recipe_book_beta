package view;

import data.entities.Ingredient;
import data.entities.IngredientId;
import data.entities.Product;
import logic.IngredientService;
import logic.ProductService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class IngredientController {

    private final IngredientService service;

    @Autowired
    public IngredientController(IngredientService service) {
        this.service = service;
    }

    @GetMapping("/ingredients")
    public List<Ingredient> getIngredients() {
        return service.findAll();
    }

    @GetMapping("/ingredient/{idRecipe}/{idProduct}")
    public Ingredient getIngredient(@PathVariable Long idRecipe, @PathVariable Long idProduct) {
        Hibernate.initialize(service.findById(idRecipe, idProduct));
        return service.findById(idRecipe, idProduct);
    }

    @PostMapping("/ingredient/new")
    public List<Ingredient> create(@RequestBody Ingredient ingredient) {
        service.add(ingredient);
        return service.findAll();
    }

    @PutMapping("/ingredient/{idRecipe}/{idProduct}")
    public List<Ingredient> update(@PathVariable Long idRecipe, @PathVariable Long idProduct, @RequestBody Ingredient ingredient) {
        //todo entering id to request body is optional
        if (service.findById(idRecipe, idProduct) != null)
            service.add(ingredient);
        return service.findAll();
    }

    @DeleteMapping("/ingredient/{idRecipe}/{idProduct}")
    public void delete(@PathVariable Long idRecipe, @PathVariable Long idProduct) {
        service.deleteById(idRecipe, idProduct);
    }
}
