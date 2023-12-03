package use_case.recipe;
import entity.Food;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.List;

public class RecipeController {
    final RecipeInputBoundary interactor;

    public RecipeController(RecipeInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String recipeName, LinkedHashMap< List<String>, Integer> strIngredients){
        LinkedHashMap<Food, Integer> ingredients = new LinkedHashMap<Food, Integer>();
        Set<List<String>> foods = strIngredients.keySet();
        for (List<String> food : foods) {
            Food foodObject = new Food(food.get(0), Integer.parseInt(food.get(1)));
            ingredients.put(foodObject, strIngredients.get(food));
        }
        RecipeInputData inputData = new RecipeInputData(recipeName, ingredients);
        interactor.execute(inputData);
    }
}
