package entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;

import static org.junit.Assert.*;

public class FoodTest {

    private Food food;
    String foodName;
    float quantity;

    int kcal;

    float protein;
    float fat;
    float carbs;

    @Before
    public void init() {
        foodName = "apple";
        quantity = 1.0f;
        kcal = 100;
        protein = 100f;
        fat = 10f;
        carbs = 10f;
        food = new Food(
                "apple",
                1.0f
        );
    }

    @Test
    public void getName() {
        assertEquals(food.getName(), foodName);
    }

    @Test
    public void getQuantity() {
        System.out.println(food.getQuantity());
        System.out.println(quantity);
        assertEquals(food.getQuantity(), quantity, 0.0001);
    }


}