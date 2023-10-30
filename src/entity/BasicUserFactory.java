package entity;

import java.util.ArrayList;

public class BasicUserFactory {

    public User create(String name, String gender, Double weight, int age,
                       Double height, ArrayList<String> dietaryRestrictions){
        return new BasicUser(name, gender, weight, age, height, dietaryRestrictions);
    }

}
