package data_access;


import entity.UserFactory;
import entity.User;
import use_case.signup.SignupDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

import java.io.*;
import java.util.*;

public class FileUserDataAccessObject implements SignupDataAccessInterface, LoginUserDataAccessInterface {

    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, User> accounts = new HashMap<>();
    private final UserFactory userFactory; // I changed this to the abstracted version :) - Alessia

    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;

        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("name", 2);
        headers.put("gender", 3);
        headers.put("weight", 4);
        headers.put("age", 5);
        headers.put("height", 6);
        headers.put("dietary restrictions", 7);

        if (csvFile.length() == 0) {
            save();
        }

        else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("username,password,name,gender,weight,age,height,dietary restrictions");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    String name = String.valueOf(col[headers.get("name")]);
                    String gender = String.valueOf(col[headers.get("gender")]);
                    Double weight = Double.valueOf(col[headers.get("weight")]);
                    int age = Integer.parseInt(col[headers.get("age")]);
                    Double height = Double.valueOf(col[headers.get("height")]);
                    String dietaryRestriction = (col[headers.get("dietary restrictions")]);
                    ArrayList<String> dietaryRestrictions = new ArrayList<>(Arrays.asList(dietaryRestriction.split
                            ("\\s*,\\s*")));
                    User user = userFactory.create(username, password, name, gender, weight, age, height,
                            dietaryRestrictions);
                    accounts.put(username, user);
                }
            }
        }
    }

    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    @Override
    public void saveNewUser(User user) {
        accounts.put(user.getName(), user);
        this.save();
    }

    @Override
    public User get(String username) {
        return accounts.get(username);
    }


    public void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {

                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                        user.getUser(), user.getPassword(), user.getName(), user.getGender(), user.getWeight(),
                        user.getAge(), user.getHeight(), user.getRestrictions());

                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
