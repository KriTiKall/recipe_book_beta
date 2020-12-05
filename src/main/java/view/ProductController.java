package view;

import data.entities.Product;
import logic.ProductService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id) {
        Hibernate.initialize(service.findById(id));
        return service.findById(id);
    }

    @PostMapping("/product/new")
    public List<Product> create(@RequestBody Product product) {
        service.add(product);
        return service.findAll();
    }

    @PutMapping("/product/{id}")
    public List<Product> update(@PathVariable Long id, @RequestBody Product product) {
        //todo bug with added new product a ne change
        if (service.findById(id) != null)
            service.add(product);
        return service.findAll();
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
