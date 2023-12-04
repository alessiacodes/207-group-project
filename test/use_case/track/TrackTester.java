package use_case.track;


import data_access.EdamamApiAccess;

import entity.Food;
import entity.Tracker;
import entity.User;
import org.junit.Test;


import java.util.HashMap;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class TrackTester {

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

    @Test
    public void testWasEntryAdded(){
        Tracker tracker = TrackTester();
        Food eggs = new Food("Egg", 2F);
        assert tracker.getDiary().contains(eggs);
    }

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
        Food food = new Food("Apple", 1.0F);
        TrackInputData inputData = new TrackInputData(food, tracker);

        // Invoke the interactor
        interactor.execute(inputData);

        System.out.println(tracker.getTotalCalories());

        // Validate the output data using the mock presenter
        assertEquals("Apple", presenter.getOutputData().getFood().getName());


    }

    // MockTrackPresenter for testing purposes
    static class MockTrackPresenter implements TrackOutputBoundary {

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
