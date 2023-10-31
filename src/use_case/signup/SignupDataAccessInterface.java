package use_case.signup;

import entity.User;

public interface SignupDataAccessInterface {

    // Checks if the user is already registered in the system. To be implemented in a Data Access Object
    boolean existsByName(String identifier);

    // Records the user information into the system. To be implemented in a Data Access Object
    void save(User user);
}