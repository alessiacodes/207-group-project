package entity;

import java.util.ArrayList;

public interface User {

    void setName();

    void setGender();

    void setAge();

    void setHeight();

    void setRestrictions();

    void setWeight();

    User getUser();

    ArrayList<String> getFavourites();

    String getName();

    String getGender();

    int getAge();

    Double getHeight();

    ArrayList<String> getRestrictions();

    Double getWeight();

}
