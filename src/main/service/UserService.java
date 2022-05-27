package main.service;

import main.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService{
    void save(User user);
    List<User> listAll();
    User get(Long id);
    void delete(Long id);
}
