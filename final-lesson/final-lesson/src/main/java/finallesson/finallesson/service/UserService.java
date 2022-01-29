package finallesson.finallesson.service;

import finallesson.finallesson.cache.UserCache;
import finallesson.finallesson.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class UserService {

    private final UserCache userCache;

    @Autowired
    public UserService(UserCache userCache) {
        this.userCache = userCache;
    }

    public List<User> getAll() {
        return userCache.getAllUsers();
    }

    public User getById(Integer id) {
        return userCache.getUserById(id);
    }

    public void createUser(User user) {
        userCache.save(user);
    }

    public void updateUser(Integer id, User user) {
        User userForUPdate = userCache.getUserById(id);
        if (Objects.isNull(userForUPdate)) {

        }
    }

    public void deleteUser(Integer id) {
        userCache.delete(id);
    }
}
