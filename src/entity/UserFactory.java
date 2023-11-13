package entity;

import java.util.ArrayList;

public interface UserFactory {

    User create(String username, String password, String name, String gender, Double weight, int age,
                Double height, ArrayList<String> dietaryRestrictions);

}
