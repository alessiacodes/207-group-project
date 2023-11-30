package use_case.login;

public interface LoginOutputBoundary {
    void prepareSuccessView(LoginOutpuData user);

    void prepareFailView(String error);
    }

}
