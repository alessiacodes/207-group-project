package use_case.track;

public class TrackPresenter implements TrackOutputBoundary {

    @Override
    public void prepareSuccessView(TrackOutputData outputData) {
        System.out.println("Successfully tracked food: " + outputData.getFood().getName());
    }

    @Override
    public void prepareFailView(String error) {
        System.out.println("Error: " + error);
    }
}
