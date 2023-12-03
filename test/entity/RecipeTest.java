package entity;

import org.junit.Test;
import java.util.LinkedHashMap;

import static org.junit.Assert.*;

public class RecipeTest {

    public void setUp(){
        Food rice = new Food("rice", 1);
        Food carrots = new Food("carrots", 1);
        Food egg = new Food("egg", 1);

        LinkedHashMap<Food, Integer> ingre = new LinkedHashMap<Food, Integer>();

        ingre.put(rice, 2);
        ingre.put(carrots, 1);
        ingre.put(egg, 3);

        Recipe test = new Recipe("fried rice", ingre, null, null);
    }

    @Test
    public void getRecipeName() {
    }

    @Test
    public void getIngredients() {
    }

    @Test
    public void getkCal() {
    }

    @Test
    public void getTotalNutrients() {
    }
}