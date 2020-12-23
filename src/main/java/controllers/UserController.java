package controllers;

import data.entities.User;
import logic.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {

    private final Service<Long, User> service;

    @Autowired
    public UserController(Service<Long, User> service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return service.findAll();
    }

    @PostMapping("/user/new")
    public List<User> create(@RequestBody User user) {
        return service.add(user);
    }

    @GetMapping("/user/{id}")
    public User get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/user/{id}")
    public List<User> update(@PathVariable Long id, @RequestBody User user) {
        return service.update(id, user);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
