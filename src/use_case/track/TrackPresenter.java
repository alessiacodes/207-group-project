package use_case.track;

public class TrackPresenter implements TrackOutputBoundary {

    private final TrackViewModel trackViewModel;

    public TrackPresenter(TrackViewModel trackViewModel) {
        this.trackViewModel = trackViewModel;
    }

    @Override
    public void prepareSuccessView(TrackOutputData outputData) {
        System.out.println("Successfully tracked food: " + outputData.getFood().getName());
        System.out.println(outputData.getTracker().getTotalNutrition());
        TrackState state = trackViewModel.getState();
        state.setTracker(outputData.getTracker());
        state.setFood(outputData.getFood());
        state.setFoodDiary(outputData.getTracker().getDiary());
        state.setWaterDiary(outputData.getTracker().getWaterDiary());
        state.setNutritionalValues(outputData.getTracker().getTotalNutrition());

        trackViewModel.setState(state);
        trackViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        TrackState state = trackViewModel.getState();
        System.out.println("Error: " + error);
        trackViewModel.setState(state);
        trackViewModel.firePropertyChanged();
    }
}
