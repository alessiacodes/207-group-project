package entity;
import java.util.ArrayList;

public interface User {

    void setName(String name);

    void setGender(String gender);

    void setAge(int age);

    void setHeight(Double height);

    void setRestrictions(ArrayList<String> dietaryRestrictions);

    void setWeight(Double weight);

    User getUser();

    String getPassword();

    String getName();

    String getGender();

    int getAge();

    Double getHeight();

    ArrayList<String> getRestrictions();

    Double getWeight();

}
