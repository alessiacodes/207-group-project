package use_case.track;
import entity.Food;
import entity.Tracker;

public class TrackInteractor implements TrackInputBoundary {

    final TrackDataAccessInterface trackDataAccessObject;
    final TrackOutputBoundary trackPresenter;

    public TrackInteractor(TrackDataAccessInterface trackDataAccessObject, TrackOutputBoundary trackPresenter) {
        this.trackDataAccessObject = trackDataAccessObject;
        this.trackPresenter = trackPresenter;
    }

    @Override
    public void execute(TrackInputData trackInputData) {
        Tracker tracker = trackInputData.getTracker();
        Food food = trackInputData.getFood();
        tracker.addFood(food);

        TrackOutputData foodOutput = new TrackOutputData(food);


        if (tracker.getDiary().contains(food)) {
            trackPresenter.prepareSuccessView(foodOutput);
        }
        else {
            trackPresenter.prepareFailView("Food was not added. Please try again.");
        }
    }
}
