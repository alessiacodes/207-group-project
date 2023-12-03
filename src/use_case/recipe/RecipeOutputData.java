package use_case.recipe;

import entity.Food;
import entity.Recipe;

import java.util.LinkedHashMap;
import java.util.HashMap;

public class RecipeOutputData {
    private final String recipeName;

    private final LinkedHashMap<Food, Integer> ingredients;

    private final Integer kCal;

    private final HashMap<String, Float> totalNutrients;

    public RecipeOutputData(String recipeName, LinkedHashMap<Food, Integer> ingredients, Integer kCal,
                            HashMap<String, Float> totalNutrients) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.kCal = kCal;
        this.totalNutrients = totalNutrients;
    }

    public String getRecipeName() {return this.recipeName;}
    public LinkedHashMap<Food, Integer> getIngredients() {return this.ingredients;}
    public Integer getkCal() {return this.kCal;}
    public HashMap<String, Float> getTotalNutrients() {return this.totalNutrients;}

}
