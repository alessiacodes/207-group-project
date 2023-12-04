package entity;

import java.util.ArrayList;

public class BasicUserFactory implements UserFactory{

    public User create(String username, String password, String name, String gender, Float weight, int age,
                       Float height, ArrayList<String> dietaryRestrictions){
        return new BasicUser(username, password, name, gender, weight, age, height, dietaryRestrictions);
    }

}
