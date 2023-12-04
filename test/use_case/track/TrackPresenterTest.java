package use_case.track;

import entity.Food;
import entity.Tracker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Mock TrackOutputBoundary for testing purposes

public class TrackPresenterTest {

    private TrackState trackState = new TrackState();
    private TrackViewModel trackViewModel = new TrackViewModel(trackState);
    private Food food = new Food("Apple", 1.0F);
    private Tracker tracker = new Tracker();
    private TrackOutputData trackOutputData = new TrackOutputData(food, tracker);
    private TrackPresenter trackPresenter = new TrackPresenter(trackViewModel);


    @Test
    public void prepareSuccessView() {
        // Create a sample food and tracker
        Food food = new Food("Banana", 1);
        Tracker tracker = new Tracker();

        trackPresenter.prepareSuccessView(trackOutputData);
        assertEquals(trackOutputData.getFood(), trackState.getFood());
        assertEquals(trackOutputData.getTracker(), trackState.getTracker());
        assertEquals("", trackState.getErrorMessage());

    }

    @Test
    public void prepareFailView() {
        // Create a sample error message
        String errorMessage = "Food not tracked successfully";

        // Call prepareFailView with the error message
        trackPresenter.prepareFailView(errorMessage);

        // Validate that the error message in the TrackState matches the input
        assertEquals(errorMessage, trackState.getErrorMessage());
    }
}
