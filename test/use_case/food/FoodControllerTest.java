package use_case.food;

import org.junit.Test;

import static org.junit.Assert.*;

public class FoodControllerTest {

    private FakeFoodInputBoundary interactor = new FakeFoodInputBoundary();
    @Test
    public void execute() {

        //        Creating parameters for testing controller

        String foodName = "apple";
        Float quantity = 1.0f;

        FoodController foodController = new FoodController(interactor);
        foodController.execute(foodName, quantity);

        //        Checking if the expected input data was used in execute
        //
        FoodInputData expected = new FoodInputData(foodName, quantity);
        assertEquals(expected.getFoodName(), interactor.getLastExecutedFoodInputData().getFoodName());
        assertEquals(expected.getFoodQuantity(), interactor.getLastExecutedFoodInputData().getFoodQuantity(), 0.001);

    }

    private static class FakeFoodInputBoundary implements FoodInputBoundary{

        private FoodInputData lastExecutedInputData;
        @Override
        public void execute(FoodInputData foodInputData) {
            lastExecutedInputData = foodInputData;
        }

        public FoodInputData getLastExecutedFoodInputData() {
            return lastExecutedInputData;
        }
    }
}