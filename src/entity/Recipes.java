package entity;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public interface Recipes {
    String getRecipeName();

    LinkedHashMap<Food, Integer> getIngredients();

    Integer getkCal();

    LinkedHashMap<String, Double> getTotalNutrients();
}
