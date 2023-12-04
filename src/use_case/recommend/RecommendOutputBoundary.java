package use_case.recommend;

public interface RecommendOutputBoundary {

    void prepareSuccessView(RecommendOutputData outputData);

    void prepareFailView(String error);
}
