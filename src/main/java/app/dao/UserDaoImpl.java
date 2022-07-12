package app.dao;

import app.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser(User u) {

    }

    @Override
    public void removeUser(long id) {

    }

    @Override
    public void changeUser() {

    }
    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.empty();
    }

    // Удалить после перехода от списка к ДБ
    public User show(long id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(1, "Sergey"));
        users.add(new User(2, "Ivan"));
        users.add(new User(3, "Nikolai"));
    }

    @Override
    public List<User> index() {
        return users;
    }
}
