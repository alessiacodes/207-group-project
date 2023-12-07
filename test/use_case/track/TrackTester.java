package use_case.track;

import data_access.EdamamApiAccess;

import entity.Food;
import entity.Tracker;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Versatile class to test general functionality of the Tracker entity.
 */
public class TrackTester {

    /**
     * A method to set up a Tracker with some initial entries for testing purposes.
     * @return Initialized Tracker for testing.
     */
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

    /**
     * Test to check if a food entry was added successfully.
     */
    @Test
    public void testWasEntryAdded() {
        Tracker tracker = TrackTester();
        Food eggs = new Food("Egg", 2F);
        assertTrue(tracker.getDiary().contains(eggs));
    }

    /**
     * Test the TrackInteractor functionality.
     */
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

        // Checking if calories are correct
        assertEquals(94.64, tracker.getTotalCalories(), 0.01);

        // Validate the output data using the mock presenter
        assertEquals("Apple", presenter.getOutputData().getFood().getName());
    }

    /**
     * Test for handling invalid inputs.
     */
    @Test
    public void testInvalidInputs() {
        // Create a mock data access object
        Tracker tracker = new Tracker();
        TrackDataAccessInterface dataAccessObject = new EdamamApiAccess();

        // Create a mock presenter
        MockTrackPresenter presenter = new MockTrackPresenter();

        // Create the interactor
        TrackInteractor interactor = new TrackInteractor(dataAccessObject, presenter);

        // Testing invalid inputs
        Food invalidFood = new Food("Wood", 2.0F);
        TrackInputData invalidInput = new TrackInputData(invalidFood, tracker);
        interactor.execute(invalidInput);

        Food invalidFood2 = new Food("", 2.0F);
        TrackInputData invalidInput2 = new TrackInputData(invalidFood2, tracker);
        interactor.execute(invalidInput2);

        Food invalidFood3 = new Food("svefverg", 2.0F);
        TrackInputData invalidInput3 = new TrackInputData(invalidFood3, tracker);
        interactor.execute(invalidInput3);
    }

    /**
     * Test for handling multiple inputs.
     */
    @Test
    public void testMultipleInputs() {
        // Create a mock data access object
        Tracker tracker = new Tracker();
        TrackDataAccessInterface dataAccessObject = new EdamamApiAccess();

        // Create a mock presenter
        MockTrackPresenter presenter = new MockTrackPresenter();

        // Create the interactor
        TrackInteractor interactor = new TrackInteractor(dataAccessObject, presenter);

        // Testing multiple inputs
        Food apple = new Food("Apple", 2.0F);
        Food pear = new Food("Pear", 1.0F);

        TrackInputData inputOne = new TrackInputData(apple, tracker);
        TrackInputData inputTwo = new TrackInputData(pear, tracker);

        interactor.execute(inputOne);
        interactor.execute(inputTwo);

        assertEquals("Apple", tracker.getDiary().get(0).getName());
        assertEquals("Pear", tracker.getDiary().get(1).getName());
    }

    /**
     * Test for updating a food entry.
     */
    @Test
    public void testUpdateFoodEntry() {
        // Create a mock data access object
        Tracker tracker = new Tracker();
        TrackDataAccessInterface dataAccessObject = new EdamamApiAccess();

        // Create a mock presenter
        MockTrackPresenter presenter = new MockTrackPresenter();

        // Create the interactor
        TrackInteractor interactor = new TrackInteractor(dataAccessObject, presenter);

        // Testing updating a food entry
        Food apple = new Food("Apple", 2.0F);
        Food pear = new Food("Pear", 1.0F);

        TrackInputData inputOne = new TrackInputData(apple, tracker);
        TrackInputData inputTwo = new TrackInputData(pear, tracker);

        interactor.execute(inputOne);
        interactor.execute(inputTwo);

        tracker.updateFoodEntry("Apple", 2.0F);

        System.out.println(tracker.getDiary().get(0).getQuantity());

        assertEquals(2.0F, tracker.getDiary().get(0).getQuantity(), 0.0F);
    }

    /**
     * Test for an empty tracker.
     */
    @Test
    public void testEmptyTracker() {
        Tracker tracker = new Tracker();
        assertTrue(tracker.isEmpty());
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

    @Test
    public void testFoodDiary() {
        // Create a mock data access object
        Tracker tracker = new Tracker();
        TrackDataAccessInterface dataAccessObject = new EdamamApiAccess();

        // Create a mock presenter
        MockTrackPresenter presenter = new MockTrackPresenter();

        // Create the interactor
        TrackInteractor interactor = new TrackInteractor(dataAccessObject, presenter);

        // Start with an empty tracker
        assertTrue(tracker.isEmpty());
        assertTrue(tracker.getDiary().isEmpty());

        // Adding a bunch of foods to the tracker
        List<Food> foods = getFoodList();

        // setting the tracker's food diary to match external one
        tracker.setFoodDiary(foods);

        assertTrue(tracker.getDiary().get(5).getName() == "Bread");
    }

    @NotNull
    private static List<Food> getFoodList() {
        Food apple = new Food("Apple", 2.0F);
        Food pear = new Food("Pear", 1.0F);
        Food eggs = new Food("Eggs", 2.0F);
        Food eggWhites = new Food("Egg Whites", 4.0F);
        Food almonds = new Food("Almonds", 10.0F);
        Food bread = new Food("Bread", 2.0F);

        // Creating external food diary
        List<Food> foods = new ArrayList<Food>();
        foods.add(apple);
        foods.add(pear);
        foods.add(eggs);
        foods.add(eggWhites);
        foods.add(almonds);
        foods.add(bread);
        return foods;
    }

    @Test
    public void testDietType() {
        // Create a mock data access object
        Tracker tracker = new Tracker();
        TrackDataAccessInterface dataAccessObject = new EdamamApiAccess();

        // Create a mock presenter
        MockTrackPresenter presenter = new MockTrackPresenter();

        // Create the interactor
        TrackInteractor interactor = new TrackInteractor(dataAccessObject, presenter);

        // Start with an empty tracker
        assertTrue(tracker.isEmpty());
        assertTrue(tracker.getDiary().isEmpty());

        // Adding a bunch of foods to the tracker
        Food apple = new Food("Apple", 2.0F);
        Food pear = new Food("Pear", 1.0F);
        Food eggs = new Food("Eggs", 2.0F);
        Food eggWhites = new Food("Egg Whites", 4.0F);
        Food salmon = new Food("Salmon", 1.0F);
        Food chicken = new Food("Chicken Breast", 2.0F);

        TrackInputData inputOne = new TrackInputData(apple, tracker);
        TrackInputData inputTwo = new TrackInputData(pear, tracker);
        TrackInputData inputThree = new TrackInputData(eggs, tracker);
        TrackInputData inputFour = new TrackInputData(eggWhites, tracker);
        TrackInputData inputFive = new TrackInputData(salmon, tracker);
        TrackInputData inputSix = new TrackInputData(chicken, tracker);

        interactor.execute(inputOne);
        interactor.execute(inputTwo);
        interactor.execute(inputThree);
        interactor.execute(inputFour);
        interactor.execute(inputFive);
        interactor.execute(inputSix);

        assertTrue(tracker.isHighProtein());
        assertTrue(!tracker.isLowCarb());
    }
}
