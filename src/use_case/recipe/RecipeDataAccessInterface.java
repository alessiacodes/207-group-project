package use_case.recipe;
import entity.Food;
import entity.Recipe;
import org.json.JSONArray;

import java.util.HashMap;

public interface RecipeDataAccessInterface {
    Integer getFoodCalories(String foodName, Float quantity);

    HashMap<String, Double> getFoodNutritionalValues(String foodName, Float quantity);


}
