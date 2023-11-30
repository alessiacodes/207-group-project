package use_case.signup;

public class SignupPresenter implements SignupOutputBoundary{
    private final SignupViewModel signupViewModel;

    public  SignupPresenter(SignupViewModel signupViewModel){
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void prepareSuccessView(SignupOutputData outputData) {

        String successMessage = "Successfully created user: " + outputData.getUsername() +". Welcome! 💚";
        SignupState state = signupViewModel.getState();
        state.setUsername(outputData.getUsername());
        state.setCurrentSuccessMessage(successMessage);
        signupViewModel.setState(state);
        signupViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}
