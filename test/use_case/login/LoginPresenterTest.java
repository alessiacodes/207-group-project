package use_case.login;

import org.junit.Test;
import use_case.recipe.RecipeOutputData;
import use_case.recipe.RecipePresenter;
import use_case.recipe.RecipeState;
import use_case.recipe.RecipeViewModel;

import static org.junit.Assert.*;

public class LoginPresenterTest {

    private LoginViewModel viewModel = new LoginViewModel();
    private LoginOutputData outputData = new LoginOutputData("Marvn", false);
    private LoginPresenter presenter = new LoginPresenter(viewModel);

    @Test
    public void prepareSuccessView() {
        LoginState state = viewModel.getState();
        presenter.prepareSuccessView(outputData);

        assertEquals(outputData.getUsername(), viewModel.getState().getUsername());
        assertEquals(state, viewModel.getState());
    }

    @Test
    public void prepareFailView() {
        LoginState state = viewModel.getState();
        presenter.prepareFailView("RuntimeException");
        assertEquals(state, viewModel.getState());
    }
}