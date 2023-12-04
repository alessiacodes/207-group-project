package use_case.recommend;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RecommendControllerTest {

    private FakeRecommendInputBoundary interactor = new FakeRecommendInputBoundary();


    @Test
    public void execute() {
        // create parameters needed for execute
        ArrayList<String> diet = new ArrayList<String>();
        diet.add("high-protein");
        ArrayList<String> health = new ArrayList<String>();
        health.add("vegan");
        String mealType = "Dinner";

        RecommendController recommendController = new RecommendController(interactor);
        recommendController.execute(diet, health, mealType);

        // check if the expected input data was used in execute
        RecommendInputData expected = new RecommendInputData(diet, health, mealType);
        assertEquals(expected.getDiet(), interactor.getLastExecutedInputData().getDiet());
        assertEquals(expected.getHealth(), interactor.getLastExecutedInputData().getHealth());
        assertEquals(expected.getMealType(), interactor.getLastExecutedInputData().getMealType());

    }



    // implement recommend input boundary to use for testing
    private static class FakeRecommendInputBoundary implements RecommendInputBoundary {
        private RecommendInputData lastExecutedInputData;

        @Override
        public void execute(RecommendInputData inputData) {
            //saves most recently added input data
            lastExecutedInputData = inputData;
        }

        public RecommendInputData getLastExecutedInputData() {
            // allows us to test that the correct input data was used
            return lastExecutedInputData;
        }
    }


}