package use_case.recipe;

import entity.Food;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

import entity.Recipe;
import data_access.EdamamApiAccess;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class RecipeInteractorTest {

    @Test
    public void testSuccess() {
        Food rice = new Food("rice", 1);
        Food egg = new Food("egg", 1);

        LinkedHashMap<Food, Integer> ingredients = new LinkedHashMap<Food, Integer>();

        ingredients.put(rice, 2);
        ingredients.put(egg, 1);

        RecipeInputData inputData = new RecipeInputData("egg rice", ingredients);

        RecipeDataAccessInterface recipeDataAccessObject = new EdamamApiAccess();

        RecipeOutputBoundary successPresent = new RecipeOutputBoundary() {
            @Override
            public void prepareSuccessView(RecipeOutputData outputData) {
                assertEquals(outputData.getRecipeName(), "egg rice");
                assertEquals(outputData.getIngredients(), ingredients);
                assertEquals(outputData.getkCal(), Integer.valueOf(235));
                assertNotNull(outputData.getTotalNutrients());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");
            }
        };

        RecipeInputBoundary interactor = new RecipeInteractor(recipeDataAccessObject, successPresent);
        interactor.execute(inputData);
    }
}
