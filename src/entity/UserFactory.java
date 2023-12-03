package entity;

import java.util.ArrayList;

public interface UserFactory {

    User create(String username, String password, String name, String gender, Float weight, int age,
                Float height, ArrayList<String> dietaryRestrictions);

}
