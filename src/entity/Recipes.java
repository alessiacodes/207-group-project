package entity;

import java.util.LinkedHashMap;
import java.util.HashMap;

public interface Recipes {
    String getRecipeName();

    LinkedHashMap<Food, Integer> getIngredients();

    Integer getkCal();

    HashMap<String, Double> getTotalNutrients();
}
