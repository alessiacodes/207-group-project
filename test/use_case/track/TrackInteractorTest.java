package use_case.track;

import data_access.EdamamApiAccess;
import entity.Food;
import entity.Tracker;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrackInteractorTest {

    @Test
    public void testTrackInteractor() {
        // Create a mock data access object
        Tracker tracker = new Tracker();
        TrackDataAccessInterface dataAccessObject = new EdamamApiAccess();


        // Create a mock presenter
        MockTrackPresenter presenter = new MockTrackPresenter();

        // Create the interactor
        TrackInteractor interactor = new TrackInteractor(dataAccessObject, presenter);

        // Create the input data object
        Food food = new Food("TestFood", 3.0F);
        TrackInputData inputData = new TrackInputData(food, tracker);

        // Invoke the interactor
        interactor.execute(inputData);

        // Validate the output data using the mock presenter
        assertEquals("TestFood", presenter.getOutputData().getFood().getName());
    }

    // MockTrackPresenter for testing purposes
    private static class MockTrackPresenter implements TrackOutputBoundary {

        private TrackOutputData outputData;

        @Override
        public void prepareSuccessView(TrackOutputData outputData) {
            System.out.println("Successfully tracked food: " + outputData.getFood().getName());
            this.outputData = outputData;
        }

        @Override
        public void prepareFailView(String error) {
            System.out.println("Error: " + error);
        }

        TrackOutputData getOutputData() {
            return outputData;
        }
    }
}
