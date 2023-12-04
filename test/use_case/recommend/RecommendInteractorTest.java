package use_case.recommend;

import data_access.EdamamApiAccess;
import org.junit.Test;
import use_case.signup.SignupOutputData;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RecommendInteractorTest {

    @Test
    public void successTest() {
        ArrayList<String> diet = new ArrayList<String>();
        diet.add("low-fat");
        ArrayList<String> health = new ArrayList<String>();
        health.add("vegetarian");

        RecommendInputData inputData = new RecommendInputData(diet, health, "Breakfast");
        RecommendDataAccessInterface recommendDataAccessObject = new EdamamApiAccess();

        RecommendOutputBoundary successPresenter = new RecommendOutputBoundary() {
            @Override
            public void prepareSuccessView(RecommendOutputData outputData) {
                assertTrue(outputData.getRecommendLink().contains("http://www.edamam.com/recipe/"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");
            }
        };

        RecommendInputBoundary interactor = new RecommendInteractor(recommendDataAccessObject, successPresenter);
        interactor.execute(inputData);

    }

}