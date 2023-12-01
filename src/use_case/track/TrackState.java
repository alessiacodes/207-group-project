package use_case.track;

import entity.Food;

import java.util.HashMap;
import java.util.List;

public class TrackState {

    private List<Food> foodDiary;
    private List<Double> waterDiary;

    private HashMap<String, Float> nutritionalValues;

    public TrackState(){}

    public void setFoodDiary(List<Food> foodDiary) {
        this.foodDiary = foodDiary;
    }

    public void setWaterDiary(List<Double> waterDiary){
        this.waterDiary = waterDiary;
    }

    public void setNutritionalValues(HashMap<String, Float> nutritionalValues){
        this.nutritionalValues = nutritionalValues;
    }

    public List<Food> getFoodDiary() {
        return this.foodDiary;
    }

    public HashMap<String, Float> getNutritionalValues() {
        return nutritionalValues;
    }

    public List<Double> getWaterDiary() {
        return waterDiary;
    }
}
