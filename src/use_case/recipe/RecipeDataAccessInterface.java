package use_case.recipe;
import entity.Food;
import entity.Recipe;
import org.json.JSONArray;

import java.util.LinkedHashMap;

public interface RecipeDataAccessInterface {
    //TODO: figure out what functions I want to include here
    // api call for calories in a recipe?
    Integer getCalories(Food identifier);

    LinkedHashMap<String, Double> getTotalNutrients(Food identifier);


}
