package view;

import data.entities.Ingredient;
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

    @GetMapping("/ingredient/{id}")
    public Ingredient getIngredient(@PathVariable Long id) {
        Hibernate.initialize(service.findById(id));
        return service.findById(id);
    }

    @PostMapping("/ingredients/new")
    public List<Ingredient> create(@RequestBody Ingredient ingredient) {
        service.add(ingredient);
        return service.findAll();
    }

    @PutMapping("/ingredient/{id}")
    public List<Ingredient> update(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        if (service.findById(id) != null)
            service.add(ingredient);
        return service.findAll();
    }

    @DeleteMapping("/ingredient/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
