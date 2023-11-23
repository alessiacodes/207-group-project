package data_access;

import entity.User;
import java.util.HashMap;
import java.util.Map;
import use_case.signup.SignupDataAccessInterface;

public class InMemoryUserDataAccessObject implements SignupDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();

    /**
     * @param identifier the user's username
     * @return whether the user exists
     */
    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    @Override
    public void saveNewUser(User user) {

    }

    /**
     * @param user the data to save
     */

    public void save(User user) {
        users.put(user.getName(), user);
    }
}