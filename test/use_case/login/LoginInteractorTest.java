package use_case.login;

import data_access.FileUserDataAccessObject;
import entity.BasicUserFactory;
import entity.UserFactory;
import org.junit.Test;
import use_case.signup.*;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LoginInteractorTest {

    @Test
    public void successTest() {
        // create user with appropriate parameters
        UserFactory userFactory = new BasicUserFactory();

        LoginInputData inputData = new LoginInputData("vpergola22", "ilovecs!");
        LoginUserDataAccessInterface userRepository;

        try {
            userRepository = new FileUserDataAccessObject("src/data_access/users.csv", userFactory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // create success presenter and test for expected result
        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                // check for correct output and if the user has been created in users.csv
                assertEquals("vpergola22", user.getUsername());
                assertFalse(user.getUseCaseFailed());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        LoginInputBoundary interactor = new LoginInteractor(userRepository, successPresenter);
        interactor.execute(inputData);


    }



}