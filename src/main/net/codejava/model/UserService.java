package main.net.codejava.model;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    final
    UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public void save(User user) {
        repo.save(user);
    }

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public User get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
