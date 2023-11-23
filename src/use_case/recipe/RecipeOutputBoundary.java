package use_case.recipe;

public interface RecipeOutputBoundary {
    /// TODO: review/finish
    void prepareSuccessView(RecipeOutputData outputData);

    void prepareFailView(String error);
}
