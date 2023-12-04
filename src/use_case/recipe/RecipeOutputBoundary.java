package use_case.recipe;

public interface RecipeOutputBoundary {
    void prepareSuccessView(RecipeOutputData outputData);

    void prepareFailView(String error);
}
