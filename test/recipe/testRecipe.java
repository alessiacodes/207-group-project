package recipe;

import use_case.recipe.RecipeDataAccessInterface;
import entity.Food;
import entity.Recipe;
import use_case.recipe.*;
import use_case.food.*;
import view.MainView;
import entity.BasicUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class testRecipe {
    public static void main(String[] args) {
        testWithoutUI();
    }

    public void testWithoutUI(){
        FakeDAO fakeDAO = new FakeDAO();
    }
}

class FakeDAO implements RecipeDataAccessInterface {
    @Override
    public Integer getCalories(Food identifier) {
        return identifier.getCalories();
    }

    @Override
    public HashMap<String, Double> getTotalNutrients(Food identifier) {
        return identifier.getTotalNutrients;
    }
}
