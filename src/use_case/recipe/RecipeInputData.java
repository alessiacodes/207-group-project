package use_case.recipe;
import entity.Food;

import java.util.LinkedHashMap;

public class RecipeInputData {
    private final String recipeName;
    private final LinkedHashMap<Food, Integer> ingredients;
    private final Integer kCal = null;
    private final LinkedHashMap<String, Double> totalNutrients = null;

    public RecipeInputData(String recipeName, LinkedHashMap<Food, Integer> ingredients) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
    }

    public String getRecipeName() {return recipeName;}
    public LinkedHashMap<Food, Integer> getIngredients() {return ingredients;}
    public Integer getkCal() {return kCal;}
    public LinkedHashMap<String, Double> getTotalNutrients() {return totalNutrients;}

}
