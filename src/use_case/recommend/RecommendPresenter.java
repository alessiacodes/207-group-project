package use_case.recommend;


public class RecommendPresenter implements RecommendOutputBoundary{
    private final RecommendViewModel recommendViewModel;

    public  RecommendPresenter(RecommendViewModel recommendViewModel){
        this.recommendViewModel = recommendViewModel;
    }

    @Override
    public void prepareSuccessView(RecommendOutputData outputData) {

        // prepare to display link for recommended recipe with message
        String successMessage = "Here is your recipe recommendation: " + outputData.getRecommendLink() +" 💚";
        RecommendState state = recommendViewModel.getState();

        // update state and display result
        state.setRecommendLink(outputData.getRecommendLink());
        state.setCurrentSuccessMessage(successMessage);
        recommendViewModel.setState(state);
        recommendViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // TODO might need fixing
        // update state
        RecommendState state = recommendViewModel.getState();
        state.setCurrentErrorMessage(error);
        recommendViewModel.setState(state);
        recommendViewModel.firePropertyChanged();
    }
}
