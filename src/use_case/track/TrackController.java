package use_case.track;

import entity.Food;
import entity.Tracker;
import use_case.track.TrackInputBoundary;
import use_case.track.TrackInputData;

public class TrackController {

    private final TrackInputBoundary trackInteractor;
    private final Tracker tracker;

    public TrackController(TrackInputBoundary trackInteractor, Tracker tracker) {
        this.trackInteractor = trackInteractor;
        this.tracker = tracker;
    }

    public void execute(String foodName, String quantity) {
        // Gather input data
        Food food = new Food(foodName, Float.parseFloat(quantity));
        TrackInputData input = new TrackInputData(food, tracker);

        // Execute the use case
        trackInteractor.execute(input);
    }
}
