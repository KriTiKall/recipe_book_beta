package view;

import data.entities.Recipe;
import data.entities.User;
import logic.RecipeService;
import logic.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return service.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        Hibernate.initialize(service.findById(id));
        return service.findById(id);
    }

    @PostMapping("/user/new")
    public List<User> create(@RequestBody User user) {
        service.add(user);
        return service.findAll();
    }

    @PutMapping("/user/{id}")
    public List<User> update(@PathVariable Long id, @RequestBody User user) {
        if (service.findById(id) != null)
            service.add(user);
        return service.findAll();
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
