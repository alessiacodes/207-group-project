package use_case.track;

import entity.Food;

public class TrackOutputData {

    private final Food food;
    private boolean useCaseFailed;

    public TrackOutputData(Food food) {
        this.food = food;
    }

    public Food getFood(){ return food; }
}
