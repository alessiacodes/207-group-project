package use_case.food;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FoodInteractor implements FoodInputBoundary{

    final FoodDataAccessInterface foodDataAccessObject;

    final FoodOutputBoundary foodPresenter;

    public FoodInteractor(FoodDataAccessInterface foodDataAccessInterface, FoodOutputBoundary foodOutputBoundary){
        this.foodDataAccessObject = foodDataAccessInterface;
        this.foodPresenter = foodOutputBoundary;
    }

    @Override
    public void execute(FoodInputData foodInputData) {
        String name = foodInputData.getFoodName();
        float quantity = foodInputData.getFoodQuantity();
        Integer kCal;

        HashMap<String, Double> nutritionalValues = new HashMap<String, Double>();

        nutritionalValues = foodDataAccessObject.getFoodNutritionalValues(name, quantity);

        kCal = foodDataAccessObject.getFoodCalories(name, quantity);

        FoodOutputData foodOutputData = new FoodOutputData(name, nutritionalValues, kCal);

        foodPresenter.prepareSuccessView(foodOutputData);
    }
}
