package use_case.track;

import entity.Food;

public class TrackInputData {

    final private Food food;

    public TrackInputData(Food food) {
        this.food = food;
    }

    Food getFood(){
        return this.food;
    }
}
