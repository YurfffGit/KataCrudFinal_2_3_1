package app.dao;

import app.model.User;

import java.util.*;

public interface UserDao {
    List<User>getAllUsers ();
    User getUserById(int id);
    void addUser(User user);
    void removeUser(int id);
    void updateUser(User user);
}
