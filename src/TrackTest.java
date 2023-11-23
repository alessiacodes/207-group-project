import entity.Food;
import entity.Tracker;

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
    public boolean testWasEntryAdded(){
        Tracker tracker = TrackTester();
        Food eggs = new Food("Egg", 2F);
        return tracker.getDiary().contains(eggs);
    }

    @org.junit.Test
    public boolean testWasFoodEntryUpdated(){
        Tracker tracker = TrackTester();
        Food apple = new Food("Apple", 2F);
        return tracker.getDiary().contains(apple);
    }

}
