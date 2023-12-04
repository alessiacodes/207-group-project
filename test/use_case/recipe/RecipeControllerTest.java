package use_case.recipe;

import data_access.EdamamApiAccess;
import entity.Food;
import org.junit.Before;
import org.junit.Test;
import entity.Recipe;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.*;

public class RecipeControllerTest {

    private FakeRecipeInputBoundary interactor = new FakeRecipeInputBoundary();

    @Test
    public void execute() {
        // initialize expected recipe
        Food rice = new Food("rice", 1);
        Food carrots = new Food("carrots", 1);
        Food egg = new Food("egg", 1);

        LinkedHashMap<Food, Integer> ingredients = new LinkedHashMap<Food, Integer>();

        ingredients.put(rice, 2);
        ingredients.put(carrots, 1);
        ingredients.put(egg, 3);

        String name = "fried rice";
        Recipe expected = new Recipe(name, ingredients, null, null);

        //initialize test recipe
        LinkedHashMap<List<String>, Integer> ingre = new LinkedHashMap<List<String>, Integer>();

        List<String> riceTest = new ArrayList<String>();
        riceTest.add(0,"rice");
        riceTest.add(1,"1");

        List<String> carrotsTest = new ArrayList<String>();
        carrotsTest.add(0,"carrots");
        carrotsTest.add(1,"1");

        List<String> eggTest = new ArrayList<String>();
        eggTest.add(0,"egg");
        eggTest.add(1,"1");

        ingre.put(riceTest, 2);
        ingre.put(carrotsTest, 1);
        ingre.put(eggTest, 3);

        RecipeController controller = new RecipeController(interactor);
        controller.execute(name, ingre);

        //check if equal
        assertEquals(expected.getRecipeName(), interactor.getLastInput().getRecipeName());
        assertEquals(expected.getIngredients(), interactor.getLastInput().getIngredients());

    }

    private static class FakeRecipeInputBoundary implements RecipeInputBoundary {
        private RecipeInputData lastInput;

        @Override
        public void execute(RecipeInputData input) {
            lastInput = input;
        }

        public RecipeInputData getLastInput() { return lastInput; }
    }
}

//    private Recipe test;
//    private RecipeController controller;
//    private RecipeInputBoundary interactor;
//
//    LinkedHashMap<Food, Integer> ingredients = new LinkedHashMap<Food, Integer>();
//    HashMap<String, Double> nutrients = new HashMap<String, Double>();
//
//    @BeforeEach
//    public void setUp(){
//        Food rice = new Food("rice", 1);
//        Food carrots = new Food("carrots", 1);
//        Food egg = new Food("egg", 1);
//
//        ingredients.put(rice, 2);
//        ingredients.put(carrots, 1);
//        ingredients.put(egg, 3);
//
////        nutrients.put("protein", 10.0);
////        nutrients.put("carbs", 250.0);
//
//        test = new Recipe("fried rice", ingredients, null, null);
//
//        FakeRecipePresenter presenter = new FakeRecipePresenter();
//        interactor = new RecipeInteractor(new EdamamApiAccess(), presenter);
//        controller = new RecipeController(interactor);
//
//    }
//
//    @Test
//    public void testCreateRecipe() {
//        LinkedHashMap<List<String>, Integer> ingre = new LinkedHashMap<List<String>, Integer>();
//
//        List<String> rice = new ArrayList<String>();
//        rice.add(0,"rice");
//        rice.add(1,"1");
//
//        List<String> carrots = new ArrayList<String>();
//        carrots.add(0,"carrots");
//        carrots.add(1,"1");
//
//        List<String> egg = new ArrayList<String>();
//        egg.add(0,"egg");
//        egg.add(1,"1");
//
//        ingre.put(rice, 2);
//        ingre.put(carrots, 1);
//        ingre.put(egg, 3);
//
//        controller.execute("fried rice", ingre);
//
//        //assertEquals();
//    }
//
//    private static class FakeRecipePresenter implements RecipeOutputBoundary{
//
//        private RecipeOutputData output;
//        @Override
//        public void prepareSuccessView(RecipeOutputData output) {
//            System.out.println();
//            this.output = output;
//        }
//
//        @Override
//        public void prepareFailView(String error) {
//            System.out.println(error);
//            this.output = output;
//        }
//
//        RecipeOutputData getOutput() {return output;}
//    }