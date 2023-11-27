package use_case.recommend;

public class RecommendInteractor implements RecommendInputBoundary{


    final RecommendDataAccessInterface recommendDataAccessObject;

    final RecommendOutputBoundary recommendPresenter;


    public RecommendInteractor(RecommendDataAccessInterface recommendDataAccessObject, RecommendOutputBoundary recommendPresenter){
        this.recommendDataAccessObject = recommendDataAccessObject;
        this.recommendPresenter = recommendPresenter;
    }



    @Override
    public void execute(RecommendInputData inputData) {
        // TODO
    }
}
