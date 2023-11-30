package use_case.track;

import entity.Food;

public class TrackInteractor implements TrackInputBoundary {

    private final TrackDataAccessInterface dataAccess;
    private final TrackOutputBoundary outputBoundary;

    public TrackInteractor(TrackDataAccessInterface dataAccess, TrackOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(TrackInputData trackInputData) {
        Food food = trackInputData.getFood();

        // Validate input if necessary
        if (food == null || food.getName().isEmpty()) {
            outputBoundary.prepareFailView("Invalid food data");
            return;
        }

        // Perform the business logic here
        dataAccess.addFoodEntry(food);

        // Notify the presenter about the success
        outputBoundary.prepareSuccessView(new TrackOutputData(food));
    }
}
