package use_case.track;

public class TrackPresenter implements TrackOutputBoundary {

    @Override
    public void prepareSuccessView(TrackOutputData outputData) {
        // Confirming to the user that the food they consumed was tracked
        System.out.println("Successfully tracked food: " + outputData.getFood().getName());

    }

    @Override
    public void prepareFailView(String error) {
        // Telling the user there was an error when trying to track their food
        System.out.println("Error: " + error);

    }
}
