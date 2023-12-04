package use_case.recipe;

import entity.Food;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.Assert.*;

public class RecipePresenterTest {

    private RecipeViewModel viewModel = new RecipeViewModel();
    private RecipeOutputData outputData;
    private RecipePresenter presenter = new RecipePresenter(viewModel);


    @Test
    public void prepareSuccessView() {
        Food rice = new Food("rice", 1);
        Food egg = new Food("egg", 1);

        LinkedHashMap<Food, Integer> ingredients = new LinkedHashMap<Food, Integer>();
        HashMap<String, Float> nutrients = new HashMap<String, Float>();

        ingredients.put(rice, 2);
        ingredients.put(egg, 1);

        nutrients.put("protein", 10F);
        nutrients.put("carbs", 250F);

        outputData = new RecipeOutputData("egg rice", ingredients, 500, nutrients);

        RecipeState state = viewModel.getState();
        presenter.prepareSuccessView(outputData);

        assertEquals(outputData.getRecipeName(), viewModel.getState().getRecipeName());
        assertEquals(outputData.getIngredients(), viewModel.getState().getIngredients());
        assertEquals(outputData.getkCal(), viewModel.getState().getkCal());
        assertEquals(outputData.getTotalNutrients(), viewModel.getState().getTotalNutrients());
        assertEquals(state, viewModel.getState());
    }

    @Test
    public void prepareFailView() {
        RecipeState state = viewModel.getState();
        presenter.prepareFailView("RuntimeException");
        assertEquals(state, viewModel.getState());
    }
}