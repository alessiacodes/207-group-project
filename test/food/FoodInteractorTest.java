package food;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.food.FoodDataAccessInterface;
import use_case.food.FoodInteractor;
import use_case.food.FoodOutputBoundary;
import use_case.food.FoodOutputData;
import use_case.food.FoodInputData;

import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class FoodInteractorTest {

    private FoodDataAccessInterface stubDataAccess;
    private FoodInteractor foodInteractor;

    @BeforeEach
    void setUp() {
        stubDataAccess = new FoodDataAccessInterface() {
            @Override
            public HashMap<String, Double> getFoodNutritionalValues(String foodName, Float quantity) {
                HashMap<String, Double> nutritionalValues = new HashMap<>();
                nutritionalValues.put("Fiber", 4.0);
                return nutritionalValues;
            }

            @Override
            public Integer getFoodCalories(String foodName, Float quantity) {
                return 95;
            }
        };

        FoodOutputBoundary stubOutputBoundary = new FoodOutputBoundary() {
            @Override
            public void prepareSuccessView(FoodOutputData outputData) {

            }

            @Override
            public void prepareFailView(String error) {
            }
        };

        foodInteractor = new FoodInteractor(stubDataAccess, stubOutputBoundary);
    }

    @Test
    void execute_ShouldUseStubbedDataAccessMethods_WhenInvoked() {
        String foodName = "Apple";
        float quantity = 1;
        FoodInputData inputData = new FoodInputData(foodName, quantity);

        foodInteractor.execute(inputData);



        assertEquals("Apple", inputData.getFoodName());
        assertEquals(quantity, inputData.getFoodQuantity());
        assertNotNull(stubDataAccess.getFoodNutritionalValues(foodName, quantity));
        assertNotNull(stubDataAccess.getFoodCalories(foodName, quantity));
    }
}
