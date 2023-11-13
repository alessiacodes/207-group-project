package use_case.signup;

public interface SignupOutputBoundary {
    void prepareSuccessView(SignupOutputData outputData);

    // We note that any time a fail occurs in this case, we'd want to prompt the user again for better inputs
    void prepareFailView(String error);
}
