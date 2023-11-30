package use_case.track;

import entity.Food;
import entity.Tracker;

public class TrackController {

    final TrackInputBoundary trackInteractor;

    public TrackController(TrackInputBoundary trackInteractor) {
        this.trackInteractor = trackInteractor;
    }
    public void execute(Food food, Tracker tracker){
        // Initialize an InputData object for the Interactor
        TrackInputData trackInputData = new TrackInputData(food, tracker);
        trackInteractor.execute(trackInputData);
    }
}
