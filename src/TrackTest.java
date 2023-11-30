import data_access.InMemoryUserDataAccessObject;
import entity.Food;
import entity.Tracker;
import entity.User;
import org.junit.Test;
import use_case.track.TrackInputData;
import use_case.track.TrackInteractor;
import use_case.track.TrackOutputBoundary;
import use_case.track.TrackOutputData;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TrackTest {

    public Tracker TrackTester() {

        // 1) Initialize Tracker
        Tracker tracker = new Tracker();

        // 2) Ensure there's at least two entries in tracker for testing purposes
        Food apple = new Food("Apple", 1F);
        tracker.addFood(apple);
        Food eggs = new Food("Egg", 2F);
        tracker.addFood(eggs);

        // 3) Update one of the entries
        tracker.updateFoodEntry("Apple", 2F);

        return tracker;
    }

    @org.junit.Test
    public void testWasEntryAdded(){
        Tracker tracker = TrackTester();
        Food eggs = new Food("Egg", 2F);
        assert(tracker.getDiary().contains(eggs));
    }

    @org.junit.Test
    public void testWasFoodEntryUpdated(){
        Tracker tracker = TrackTester();
        Food apple = new Food("Apple", 2F);
        assert(tracker.getDiary().contains(apple));
    }

    @org.junit.Test
    public void testWasFoodDeleted(){
        Tracker tracker = TrackTester();
        Food apple = new Food("Apple", 2F);
        tracker.removeFood(apple);
        assert(!tracker.getDiary().contains(apple));
    }

    @Test
    public void testTrackInteractor() {
        // Create a mock data access object
        Tracker tracker = new Tracker();
        HashMap<String, User> users = new HashMap<>();
        InMemoryUserDataAccessObject dataAccessObject = new InMemoryUserDataAccessObject(tracker, users);

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
            this.outputData = outputData;
        }

        @Override
        public void prepareFailView(String error) {
            // Implement if needed for your testing
        }

        TrackOutputData getOutputData() {
            return outputData;
        }
    }
}
