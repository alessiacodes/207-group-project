package entity;
import java.util.ArrayList;

public interface User {

    void setName(String name);

    void setGender(String gender);

    void setAge(int age);

    void setHeight(Float height);

    void setRestrictions(ArrayList<String> dietaryRestrictions);

    void setWeight(Float weight);

    User getUser();

    String getPassword();

    String getName();

    String getGender();

    int getAge();

    Float getHeight();

    ArrayList<String> getRestrictions();

    Float getWeight();

    String getUsername();
}
