package use_case.signup;

import java.util.ArrayList;

public class SignupInputData {
    public static class SignUpInputData {
        private String username;
        private String password;
        private String name;
        private String gender;
        private int age;
        private Double height;
        private ArrayList<String> dietaryRestrictions;
        private Double weight;

        public SignUpInputData(String username,
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
}
