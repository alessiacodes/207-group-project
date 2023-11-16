package use_case.track;

public interface TrackOutputBoundary {
    void prepareSuccessView(TrackOutputData food);

    void prepareFailView(String error);
}
