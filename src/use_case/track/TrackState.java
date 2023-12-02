package use_case.track;

import entity.Food;
import entity.Tracker;

import java.util.HashMap;
import java.util.List;

public class TrackState {
    private List<Food> foodDiary;
    private List<Double> waterDiary;

    private HashMap<String, Float> nutritionalValues = new HashMap<>();

    private Tracker tracker;

    public TrackState(){}

    public void setFoodDiary(List<Food> foodDiary) {
        this.foodDiary = foodDiary;
    }

    public void setNutritionalValues(HashMap<String, Float> nutritionalValues) {
        this.nutritionalValues = nutritionalValues;
    }

    public void setWaterDiary(List<Double> waterDiary) {
        this.waterDiary = waterDiary;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    public List<Double> getWaterDiary() {
        return waterDiary;
    }

    public HashMap<String, Float> getNutritionalValues() {
        return nutritionalValues;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public List<Food> getFoodDiary() {
        return foodDiary;
    }
}
