package use_case.signup;

import entity.User;
import entity.UserFactory;

public class SignupInteractor implements SignupInputBoundary{

    final SignupDataAccessInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;
    final UserFactory userFactory;
    public SignupInteractor(SignupDataAccessInterface userDataAccessObject,
                            SignupOutputBoundary userPresenter,
                            UserFactory userFactory) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
        this.userFactory = userFactory;
    }

    // TODO: add fail case checks whether inputs are valid(eg. age is non-negative)
    @Override
    public void execute(SignupInputData inputData) {
        if (userDataAccessObject.existsByName(inputData.getUsername())) {
            userPresenter.prepareFailView("User already exists");
        }
        else {
            User user = userFactory.create(inputData.getUsername(), inputData.getPassword(), inputData.getName(),
                    inputData.getGender(), inputData.getWeight(), inputData.getAge(), inputData.getHeight(),
                    inputData.getDietaryRestrictions());
            userDataAccessObject.saveNewUser(user);

            // note: will have to update/change this b/c we need to go over outputData when we figure out the Presenter
            SignupOutputData signupOutputData = new SignupOutputData(inputData.getUsername());
            userPresenter.prepareSuccessView(signupOutputData);
        }

    }
}
