package use_case.food;

public class FoodController {

    final FoodInputBoundary foodUseCaseInteractor;


    public FoodController(FoodInputBoundary foodUseCaseInteractor) {
        this.foodUseCaseInteractor = foodUseCaseInteractor;
    }


    public void execute(String foodName, float quantity) {
        FoodInputData foodInputData = new FoodInputData(foodName, quantity);
        foodUseCaseInteractor.execute(foodInputData);
    }

}
