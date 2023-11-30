package use_case.food;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FoodInteractor {

    final FoodDataAccessInterface foodDataAccessObject;

    final FoodOutputBoundary foodPresenter;

    public FoodInteractor(FoodDataAccessInterface foodDataAccessInterface, FoodOutputBoundary foodOutputBoundary){
        this.foodDataAccessObject = foodDataAccessInterface;
        this.foodPresenter = foodOutputBoundary;
    }

//    @Override
    public void execute(FoodInputData foodInputData) {
        String name = foodInputData.getFoodName();
        float quantity = foodInputData.getFoodQuantity();

        HashMap<String, Double> nutritionalValues = new HashMap<String, Double>();

        nutritionalValues = foodDataAccessObject.getFoodNutritionalValues(name, quantity);

        FoodOutputData foodOutputData = new FoodOutputData(name, nutritionalValues);

        foodPresenter.prepareSuccessView(foodOutputData);
    }
}
