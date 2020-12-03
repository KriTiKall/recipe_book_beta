package logic;

import data.entities.Recipe;
import data.entities.User;
import data.repositoryies.RecipeRepository;
import data.repositoryies.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findById(long id) {
        return repository.getOne(id);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User add(User user) {
        return repository.save(user);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
