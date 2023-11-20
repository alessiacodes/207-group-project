package use_case.recipe;

import entity.Food;
import entity.Recipe;

import java.util.LinkedHashMap;

public class RecipeOutputData {
    private final String recipeName;

    private final LinkedHashMap<Food, Integer> ingredients;

    private final Integer kCal;

    private final LinkedHashMap<String, Double> totalNutrients;

    public RecipeOutputData(String recipeName, LinkedHashMap<Food, Integer> ingredients, Integer kCal,
                            LinkedHashMap<String, Double> totalNutrients) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.kCal = kCal;
        this.totalNutrients = totalNutrients;
    }

    public String getRecipeName() {return this.recipeName;}
    public LinkedHashMap<Food, Integer> getIngredients() {return this.ingredients;}
    public Integer getkCal() {return this.kCal;}
    public LinkedHashMap<String, Double> getTotalNutrients() {return this.totalNutrients;}

}
