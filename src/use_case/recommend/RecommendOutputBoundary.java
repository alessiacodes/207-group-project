package use_case.recommend;

public interface RecommendOutputBoundary {
    //TODO might need more
    void prepareSuccessView(RecommendOutputData outputData);

    void prepareFailView(String error);
}
