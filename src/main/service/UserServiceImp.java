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
    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> listAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public User get(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }
}
