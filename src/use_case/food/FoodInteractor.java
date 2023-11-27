package use_case.food;

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

    }
}
