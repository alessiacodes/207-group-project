package entity;

import java.util.LinkedHashMap;
import java.util.Set;

public class Recipe {
    private final String recipeName;

    private final Integer kCal;

    private final LinkedHashMap<Food, Integer> ingredients;

    Recipe(String recipeName, Integer kCal, LinkedHashMap<Food, Integer> ingredients) {
        this.recipeName = recipeName;
        this.kCal = kCal;
        this.ingredients = ingredients;
    }

    public double getTotalCalories() {
        double calories = 0;
        Set<Food> ingre = ingredients.keySet();
        for (Food food : ingre) {
            calories += ingredients.get(food) * food.getCalories();
        }
        return calories;
    }

    public LinkedHashMap<String, Double> getTotalNutrients() {
        Set<Food> ingre = ingredients.keySet();
        LinkedHashMap<String, Double> total = new LinkedHashMap<String, Double>();

        for (Food food : ingre) {
            LinkedHashMap<String, Double> hashNutrients = food.getNutritionalValues();
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

    /*
    @Override
    public String getRecipeName() {return recipeName;}

    @Override
    public Integer getkCal() {return kCal;}

    @Override
    public LinkedHashMap<Food, Integer> getIngredients() {return ingredients;}
    */

}
