package use_case.login;

import entity.User;

public interface LoginUserDataAccessInterface {
    boolean existsByName(String identifier);

    void saveNewUser(User user);

    User get(String username);
}
