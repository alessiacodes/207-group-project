package use_case.food;

public class FoodPresenter implements FoodOutputBoundary{

    private final FoodViewModel foodViewModel;

    public FoodPresenter(FoodViewModel foodViewmodel) {
        this.foodViewModel = foodViewmodel;
    }

    @Override
    public void prepareSuccessView(FoodOutputData outputData) {
//        Not sure if I need a success message
//        String successMesssage = "";

    }

    @Override
    public void prepareFailView(String error) {

    }
}
