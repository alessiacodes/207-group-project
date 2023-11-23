package data_access;

import entity.User;
import use_case.signup.SignupDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class FileUserDataAccessObject implements SignupDataAccessInterface {

    private final Map<String, User> accounts = new HashMap<>();

    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    @Override
    public void saveNewUser(User user) {

    }
    public void save(User user) {
        accounts.put(user.getName(), user);
    }
}
