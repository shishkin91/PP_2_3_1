package main.service;

import main.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserService extends CrudRepository<User, Long> {

}
