package use_case.login;

import use_case.recipe.RecipeState;
import use_case.recipe.RecipeViewModel;

public class LoginPresenter implements LoginOutputBoundary {
    private final LoginViewModel loginViewModel;

    public LoginPresenter(LoginViewModel loginViewModel) {
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData outputData) {
        LoginState state = loginViewModel.getState();
        state.setUsername(outputData.getUsername());

        loginViewModel.setState(state);
        loginViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}
