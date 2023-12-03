package use_case.track;

import entity.Food;
import entity.Tracker;

public class TrackController {

    private final TrackInputBoundary trackInteractor;

    public TrackController(TrackInputBoundary trackInteractor) {
        this.trackInteractor = trackInteractor;
    }

    public void execute(String foodName, float quantity) {
        // Gather input data
        Tracker tracker = new Tracker();
        Food food = new Food(foodName, quantity);
        TrackInputData input = new TrackInputData(food, tracker);

        // Execute the use case
        trackInteractor.execute(input);
    }
}
