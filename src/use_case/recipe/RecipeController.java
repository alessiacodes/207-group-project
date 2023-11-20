package use_case.recipe;
import entity.Food;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RecipeController {
    final RecipeInputBoundary interactor;

    public RecipeController(RecipeInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String recipeName, LinkedHashMap<Food, Integer> ingredients){
        RecipeInputData inputData = new RecipeInputData(recipeName, ingredients);
        interactor.execute(inputData);
    }
}
