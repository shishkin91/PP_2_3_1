package main.service;

import java.util.List;

import main.dao.UserDao;
import main.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService{
    @Autowired
    private final UserDao repo;

    public UserServiceImp(UserDao repo) {
        this.repo = repo;
    }

    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Override
    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    @Override
    public User get(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
