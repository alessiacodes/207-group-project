package use_case.recipe;

import java.util.HashMap;

public interface RecipeDataAccessInterface {
    Integer getFoodCalories(String foodName, Float quantity);

    HashMap<String, Float> getFoodNutritionalValues(String foodName, Float quantity);


}
