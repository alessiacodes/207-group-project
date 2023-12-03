package use_case.track;

import entity.Food;
import entity.Tracker;

public class TrackOutputData {

    private final Food food;

    private Tracker tracker;

    public TrackOutputData(Food food, Tracker tracker) {
        this.food = food;
    }

    public Food getFood(){ return food; }

    public Tracker getTracker(){ return tracker;}
}
