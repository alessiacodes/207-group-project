package use_case.signup;

import data_access.FileUserDataAccessObject;
import entity.BasicUserFactory;
import entity.User;
import entity.UserFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SignupInteractorTest {

    @Test
    public void successTest(){
        // create user with appropriate parameters
        ArrayList<String> dietaryRestrictions = new ArrayList<String>();
        dietaryRestrictions.add("vegan");
        UserFactory userFactory = new BasicUserFactory();

        SignupInputData inputData = new SignupInputData("vpergola22", "ilovecs!", "victoria",
                "female", 19, 100F, dietaryRestrictions, 100F);
        SignupDataAccessInterface userRepository;

        try {
            userRepository = new FileUserDataAccessObject("src/data_access/users.csv", userFactory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // create success presenter and test for expected result
        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                // check for correct output and if the user has been created in users.csv
                assertEquals("vpergola22", user.getUsername());
                assertTrue(userRepository.existsByName("vpergola22"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        SignupInputBoundary interactor = new SignupInteractor(userRepository, successPresenter, userFactory);
        interactor.execute(inputData);
    }


    @Test
    public void failUserExistsTest(){
        // create user with appropriate parameters
        ArrayList<String> dietaryRestrictions = new ArrayList<String>();
        dietaryRestrictions.add("vegan");
        UserFactory userFactory = new BasicUserFactory();

        SignupInputData inputData = new SignupInputData("vpergola22", "ilovecs!", "victoria",
                "female", 19, 100F, dietaryRestrictions, 100F);

        // add user to repository
        SignupDataAccessInterface userRepository;
        try {
            userRepository = new FileUserDataAccessObject("src/data_access/users.csv", userFactory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        User user = userFactory.create("vpergola22", "ilovecs!", "victoria",
                "female", 100F, 19, 100F, dietaryRestrictions);
        userRepository.saveNewUser(user);

        //create presenter and test for expected response
        SignupOutputBoundary failurePresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData outputData) {
                fail("Success is unexpected");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("User already exists", error);
            }
        };

        SignupInputBoundary interactor = new SignupInteractor(userRepository, failurePresenter, userFactory);
        interactor.execute(inputData);



    }

}