package use_case.track;
import entity.Food;
import entity.Tracker;

public class TrackInputData {

    final private Food food;
    final private Tracker tracker;

    public TrackInputData(Food food, Tracker tracker) {
        this.food = food;
        this.tracker = tracker;
    }

    Food getFood(){
        return this.food;
    }

    Tracker getTracker() {return this.tracker;};
}
