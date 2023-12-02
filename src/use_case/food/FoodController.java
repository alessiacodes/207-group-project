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



// TO-DO: Decide which method to use based on results
// And CA and Design Principles.
// Trying different implementation of the Controller class, will delete once settled.
//
//
//
//public class FoodController {
//
//    final FoodInputBoundary foodUseCaseInteractor;
//
//    public FoodController(FoodInputBoundary foodUseCaseInteractor) {
//        this.foodUseCaseInteractor = foodUseCaseInteractor;
//    }
//
//
//    public void execute(String foodName, float quantity) {
//        FoodInputData foodInputData = new FoodInputData(foodName, quantity);
//        foodUseCaseInteractor.execute(foodInputData);
//    }
//
//}
