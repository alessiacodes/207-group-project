package use_case.food;

import entity.Food;

import java.util.LinkedHashMap;

public class FoodOutputData {

    private final String foodName;

    private final LinkedHashMap<Food, Integer> ingredients;

    private final Integer kCal;

    private final LinkedHashMap<String, Double> totalNutrients;

    public FoodOutputData(String recipeName, LinkedHashMap<Food, Integer> ingredients, Integer kCal,
                            LinkedHashMap<String, Double> totalNutrients) {
        this.foodName = recipeName;
        this.ingredients = ingredients;
        this.kCal = kCal;
        this.totalNutrients = totalNutrients;
    }

    public String getFoodName() {return this.foodName;}
    public LinkedHashMap<Food, Integer> getIngredients() {return this.ingredients;}
    public Integer getkCal() {return this.kCal;}
    public LinkedHashMap<String, Double> getTotalNutrients() {return this.totalNutrients;}

}
