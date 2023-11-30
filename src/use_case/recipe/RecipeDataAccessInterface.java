package use_case.recipe;
import entity.Food;
import entity.Recipe;
import org.json.JSONArray;

import java.util.HashMap;

public interface RecipeDataAccessInterface {
    Integer getCalories(Food identifier);

    HashMap<String, Double> getTotalNutrients(Food identifier);


}
