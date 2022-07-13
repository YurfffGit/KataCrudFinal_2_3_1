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

    private static int count;

    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++count, "Сергей"));
        users.add(new User(++count, "Ivan"));
        users.add(new User(++count, "Nikolai"));
    }

    @Override
    public List<User> index() {
        return users;
    }

    public void save(User user) {
        user.setId(++count);
        users.add(user);
    }

    public void update(long id, User user) {
        User toUpdate = show(id);
        toUpdate.setName(user.getName());
    }

    public void delete(long id) {
        users.removeIf(u -> u.getId() == id);
    }
}
