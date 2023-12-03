package use_case.track;


import data_access.EdamamApiAccess;
import entity.Food;
import entity.Tracker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrackControllerTest {

    private Tracker tracker;
    private TrackController trackController;

    private TrackInputBoundary trackInteractor;

    @Before
    public void setUp() {
        // Initialize a new Tracker
        tracker = new Tracker();

        // Create a mock presenter
        MockTrackPresenter presenter = new MockTrackPresenter();

        // Create a mock interactor
        trackInteractor = new TrackInteractor(new EdamamApiAccess(), presenter);


        // Initialize the TrackController with the mock interactor and the tracker instance
        trackController = new TrackController(trackInteractor, tracker);
    }

    @Test
    public void testAddFoodToTracker() {
        // Invoke the method you want to test
        trackController.execute("Apple", "1");
        Food apple = new Food("Apple", 1F);

        // Assert that the food is in the tracker
        assertTrue(tracker.getDiary().contains(apple));
    }

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
