package logic;

import data.entities.User;
import data.repositoryies.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements logic.Service<Long, User> {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> add(User user) {
        repository.save(user);
        return findAll();
    }

    @Override
    public User findById(Long id) {
        Hibernate.initialize(repository.getOne(id));
        return repository.getOne(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
