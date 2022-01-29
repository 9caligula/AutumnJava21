package finallesson.finallesson.cache;

import finallesson.finallesson.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserCache {
    private final Map<Integer, User> users = new HashMap<>();

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(Integer id) {
        return users.get(id);
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public void delete(Integer id) {
        users.remove(id);
    }
}