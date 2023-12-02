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

        FoodState state = foodViewModel.getState();
        state.setFoodName(outputData.getFoodName());
        state.setQuantity(outputData.getQuantity());
        state.setkCal(outputData.getKcal());
        state.setNutritionalValues(outputData.getNutritionalValues());

//        SuccessMessage?

        foodViewModel.setFoodState(state);
        foodViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        FoodState state = foodViewModel.getState();

//        Error Message?
//        Should consider when API call fails

        foodViewModel.setFoodState(state);
        foodViewModel.firePropertyChanged();
    }
}
