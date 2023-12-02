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

    @Override
    public void execute(SignupInputData inputData) {
        System.out.println("current age"  + inputData.getAge());
        if (userDataAccessObject.existsByName(inputData.getUsername())) {
            userPresenter.prepareFailView("User already exists");
        }


        else if (inputData.getUsername().equals("") || inputData.getName().equals("") || inputData.getPassword().equals("")){
            System.out.println("in if");
            userPresenter.prepareFailView("Error: field left blank");
        }

        else if (0 >= inputData.getAge() || 120 <= inputData.getAge()){
            userPresenter.prepareFailView("Error: please input an age between 1-120");
        }

        else if (0 >= inputData.getWeight() || 0 >= inputData.getHeight()){
            userPresenter.prepareFailView("Error: please input a positive number for height and/or weight");
        }

        else {
            User user = userFactory.create(inputData.getUsername(), inputData.getPassword(), inputData.getName(),
                    inputData.getGender(), inputData.getWeight(), inputData.getAge(), inputData.getHeight(),
                    inputData.getDietaryRestrictions());
            System.out.println("passes here");
            userDataAccessObject.saveNewUser(user);


            // note: will have to update/change this b/c we need to go over outputData when we figure out the Presenter
            SignupOutputData signupOutputData = new SignupOutputData(inputData.getUsername());

            userPresenter.prepareSuccessView(signupOutputData);
        }

    }
}
