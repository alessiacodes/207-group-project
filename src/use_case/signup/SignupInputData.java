package use_case.signup;

import java.util.ArrayList;

public class SignupInputData {

    final private String username;
    final private String password;
    final private String name;
    final private String gender;
    final private int age;
    final private Double height;
    final private ArrayList<String> dietaryRestrictions;
    final private Double weight;


    public SignupInputData(String username,
                           String password,
                           String name,
                           String gender,
                           int age,
                           Double height,
                           ArrayList<String> dietaryRestrictions,
                           Double weight) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.dietaryRestrictions = dietaryRestrictions;
        this.weight = weight;
    }

    public String getName() { return name; }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Double getHeight() {
        return height;
    }

    public ArrayList<String> getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Double getWeight() {
        return weight;
    }
}