package use_case.food;

public class FoodOutputBoundary {
    // will have to discuss how it should work

    void prepareSuccessView(FoodOutputData outputData);

    void prepareFailView(String error);
}
