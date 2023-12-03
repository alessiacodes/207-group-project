package use_case.recipe;

public class RecipePresenter implements RecipeOutputBoundary {
    private final RecipeViewModel recipeViewModel;

    public RecipePresenter(RecipeViewModel recipeViewModel) {
        this.recipeViewModel = recipeViewModel;
    }

    @Override
    public void prepareSuccessView(RecipeOutputData outputData) {
        RecipeState state = recipeViewModel.getState();
        state.setRecipeName(outputData.getRecipeName());
        state.setIngredients(outputData.getIngredients());
        state.setkCal(outputData.getkCal());
        state.setTotalNutrients(outputData.getTotalNutrients());

        recipeViewModel.setState(state);
        recipeViewModel.firePropertyChanged();
    }

    public void prepareFailView(String error) {
        RecipeState recipeState = recipeViewModel.getState();
        recipeViewModel.firePropertyChanged();
    }
}
