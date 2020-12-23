package logic;

import data.entities.Product;
import data.repositoryies.ProductRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements logic.Service<Long, Product> {

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> add(Product product) {
        repository.save(product);
        return findAll();
    }

    @Override
    public Product findById(Long id) {
        Hibernate.initialize(repository.getOne(id));
        return repository.getOne(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
