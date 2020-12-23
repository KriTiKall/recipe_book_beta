package controllers;

import data.entities.Product;
import logic.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductController {

    private final Service<Long, Product> service;

    @Autowired
    public ProductController(Service<Long, Product> service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> getAll() {
        return service.findAll();
    }

    @PostMapping("/product/new")
    public List<Product> create(@RequestBody Product product) {
        return service.add(product);
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/product/{id}")
    public List<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return service.update(id, product);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
