package use_case.food;

import java.util.HashMap;

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

        HashMap<String, Float> nutritionalValues = new HashMap<>();

        nutritionalValues = foodDataAccessObject.getFoodNutritionalValues(name, quantity);

        kCal = foodDataAccessObject.getFoodCalories(name, quantity);

        FoodOutputData foodOutputData = new FoodOutputData(name, quantity, nutritionalValues, kCal);
        foodPresenter.prepareSuccessView(foodOutputData);
    }
}
