package entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BasicUserTest {

    private BasicUser user;

    private ArrayList<String> dietaryRestrictions;

    @Before
    public void init(){
        dietaryRestrictions = new ArrayList<String>();
        dietaryRestrictions.add("vegan");
        user = new BasicUser("vpergola22", "ilovecs!", "victoria", "female",
                100F, 19, 100F, dietaryRestrictions);
    }

    @Test
    public void getUsername() {
        String username = user.getUsername();
        assertEquals(username, "vpergola22");
    }

    @Test
    public void getPassword() {
        String password = user.getPassword();
        assertEquals(password, "ilovecs!");
    }

    @Test
    public void getDietaryRestrictions() {
        ArrayList<String> dietaryRestrictionsNew = user.getDietaryRestrictions();
        assertEquals(dietaryRestrictionsNew, dietaryRestrictions);
    }

    @Test
    public void getUser() {
        User newUser = user.getUser();
        assertEquals(newUser, user);
    }

    @Test
    public void getName() {
        String name = user.getName();
        assertEquals(name, "victoria");
    }

    @Test
    public void getGender() {
        String gender = user.getGender();
        assertEquals(gender, "female");
    }

    @Test
    public void getAge() {
        int age = user.getAge();
        assertEquals(age, 19);
    }

    @Test
    public void getHeight() {
        float height = user.getHeight();
        assertTrue(height == 100F);
    }

    @Test
    public void getRestrictions() {
        ArrayList<String> restrictions = user.getRestrictions();
        assertEquals(restrictions, dietaryRestrictions);
    }

    @Test
    public void getWeight() {
        float weight = user.getWeight();
        assertTrue(weight == 100F);
    }

    @Test
    public void setName() {
        user.setName("joe");
        assertEquals(user.getName(), "joe");
    }

    @Test
    public void setGender() {
        user.setGender("male");
        assertEquals(user.getGender(), "male");
    }

    @Test
    public void setAge() {
        user.setAge(20);
        assertEquals(user.getAge(), 20);
    }

    @Test
    public void setHeight() {
        user.setHeight(50F);
        assertTrue(50F == user.getHeight());
    }

    @Test
    public void setRestrictions() {
        ArrayList<String> restrictions = new ArrayList<String>();
        restrictions.add("vegetarian");
        user.setRestrictions(restrictions);
        assertEquals(restrictions, user.getRestrictions());
    }

    @Test
    public void setWeight() {
        user.setWeight(50F);
        assertTrue(50F == user.getWeight());
    }
}