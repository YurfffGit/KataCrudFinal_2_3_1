package app.dao;

import app.model.User;

import java.util.*;

public interface UserDao {
    void saveUser(User u);

    void removeUser(long id);

    void changeUser();

    List<User> index();

    Optional<User> getUserById(Long id);
}
