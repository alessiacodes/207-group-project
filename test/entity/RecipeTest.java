package entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;

import static org.junit.Assert.*;

public class RecipeTest {

    private Recipe test;
    LinkedHashMap<Food, Integer> ingredients = new LinkedHashMap<Food, Integer>();
    HashMap<String, Float> nutrients = new HashMap<String, Float>();

    @BeforeEach
    public void setUp(){
        Food rice = new Food("rice", 1);
        Food carrots = new Food("carrots", 1);
        Food egg = new Food("egg", 1);

        ingredients.put(rice, 2);
        ingredients.put(carrots, 1);
        ingredients.put(egg, 3);

        float temp1 = 10;
        float temp2 = 250;

        nutrients.put("protein", temp1);
        nutrients.put("carbs", temp2);

        test = new Recipe("fried rice", ingredients, 500, nutrients);
    }

    @Test
    public void getRecipeName() {
        assertEquals(test.getRecipeName(), "fried rice");
    }

    @Test
    public void getIngredients() {
        assertEquals(test.getIngredients(), ingredients);
    }

    @Test
    public void getkCal() {
        assertEquals(test.getkCal(), Integer.valueOf(500));
    }

    @Test
    public void getTotalNutrients() {
        assertEquals(test.getTotalNutrients(), nutrients);
    }
}