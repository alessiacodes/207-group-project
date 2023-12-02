package entity;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RecommendTest {

    private Recommend recommend;

    ArrayList<String> diet = new ArrayList<String>();

    ArrayList<String> health = new ArrayList<String>();

    @BeforeEach
    void init(){
        diet.add("vegan");
        health.add("high-proetin");
        recommend = new Recommend(diet, health, "Dinner");
    }

    @Test
    public void getDiet() {
        assertEquals(diet, recommend.getDiet());
    }

    @Test
    public void getHealth() {
        assertEquals(health, recommend.getHealth());
    }

    @Test
    public void getMealType() {
        assertEquals("Dinner", recommend.getMealType());
    }


    @Test
    public void setDiet() {
        ArrayList<String> newDiet = new ArrayList<String>();
        newDiet.add("vegetarian");
        recommend.setDiet(newDiet);
        assertEquals(newDiet, recommend.getDiet());
    }

    @Test
    public void setHealth() {
        ArrayList<String> newHealth = new ArrayList<String>();
        newHealth.add("low-fat");
        recommend.setDiet(newHealth);
        assertEquals(newHealth, recommend.getHealth());
    }

    @Test
    public void setMealType() {
        String newMealType = "Lunch";
        recommend.setMealType(newMealType);
        assertEquals(newMealType, recommend.getMealType());
    }


}