package use_case.track;

import entity.Food;
import entity.Tracker;
import org.junit.Test;

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
    public void testWasFoodEntryUpdated(){
        Tracker tracker = TrackTester();
        Food apple = new Food("Apple", 2F);
        assert tracker.getDiary().contains(apple);
    }
}
