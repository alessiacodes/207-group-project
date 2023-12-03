package use_case.recipe;
import entity.Recipe;
import entity.Food;

import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Set;

public class RecipeInteractor implements RecipeInputBoundary {
    final RecipeDataAccessInterface recipeDataAccessObject;
    final RecipeOutputBoundary recipePresenter;

    public RecipeInteractor(RecipeDataAccessInterface recipeDataAccessObject, RecipeOutputBoundary recipePresenter) {
        this.recipeDataAccessObject = recipeDataAccessObject;
        this.recipePresenter = recipePresenter;
    }

    @Override
    public void execute(RecipeInputData inputData) {
        LinkedHashMap<Food, Integer> ingredients = inputData.getIngredients();
        Integer calories = 0;
        Set<Food> ingre = ingredients.keySet();
        for (Food food: ingre) {
            calories += ingredients.get(food) * recipeDataAccessObject.getFoodCalories(food.getName(),
                    food.getQuantity());
        }

        HashMap<String, Double> totalNutrients = new LinkedHashMap<String, Double>();
        for (Food food: ingre) {
            HashMap<String, Double> hashNutrients = recipeDataAccessObject.getFoodNutritionalValues(food.getName(),
                    food.getQuantity());
            Set<String> nutrients = hashNutrients.keySet();
            for (String nutrient : nutrients) {
                if (totalNutrients.containsKey(nutrient)) {
                    totalNutrients.put(nutrient, (totalNutrients.get(nutrient) + hashNutrients.get(nutrient)));
                } else {
                    totalNutrients.put(nutrient, hashNutrients.get(nutrient));
                }
            }
        }

        RecipeOutputData recipeOutputData = new RecipeOutputData(inputData.getRecipeName(), inputData.getIngredients(),
                calories, totalNutrients);

        recipePresenter.prepareSuccessView(recipeOutputData);

    }
}
