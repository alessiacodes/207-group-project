package entity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Set;

public class Recipe implements Recipes {
    private final String recipeName;

    private final LinkedHashMap<Food, Integer> ingredients;

    private final Integer kCal;

    private final HashMap<String, Float> totalNutrients;

    Recipe(String recipeName, LinkedHashMap<Food, Integer> ingredients, Integer kCal, HashMap<String, Float>
           totalNutrients) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.kCal = kCal;
        this.totalNutrients = totalNutrients;
    }

    @Override
    public String getRecipeName() {return recipeName;}

    @Override
    public LinkedHashMap<Food, Integer> getIngredients() {return ingredients;}

    @Override
    public Integer getkCal() {return kCal;}

    @Override
    public HashMap<String, Float> getTotalNutrients() {return totalNutrients;}

    /*
    public Float getTotalCalories() {
        Float calories = 0;
        Set<Food> ingre = ingredients.keySet();
        for (Food food : ingre) {
            calories += ingredients.get(food) * food.getCalories();
        }
        return calories;
    }

    public LinkedHashMap<String, Float> getTotalNutrients() {
        Set<Food> ingre = ingredients.keySet();
        LinkedHashMap<String, Float> total = new LinkedHashMap<String, Float>();

        for (Food food : ingre) {
            HashMap<String, Float> hashNutrients = food.getNutritionalValues();
            Set<String> nutrients = hashNutrients.keySet();
            for (String nutrient : nutrients) {
                if (total.containsKey(nutrient)) {
                    total.put(nutrient, (total.get(nutrient) + hashNutrients.get(nutrient)));
                }
                else {
                    total.put(nutrient, hashNutrients.get(nutrient));
                }
            }
        }

        return total;
    }

    public void addFood(Food food, Integer amount) {
        ingredients.put(food, amount);
    }
    */

}
