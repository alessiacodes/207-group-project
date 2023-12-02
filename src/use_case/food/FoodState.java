package use_case.food;

import java.util.HashMap;

public class FoodState {

    private String foodName;

    private Integer kCal;

    private HashMap<String, Double> nutritionalValues;

    public FoodState(FoodState foodState) {
        foodName = foodState.foodName;
        nutritionalValues = foodState.nutritionalValues;
        kCal = foodState.kCal;
    }

    public FoodState() {
//        constructor
    }

    // Getters for the Food State
    public String getFoodName() {
        return foodName;
    };

    public Integer getkCal() {
        return kCal;
    }

    public HashMap<String, Double> getNutritionalValues() {
        return nutritionalValues;
    };


    //    Setters for the Food State

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setkCal(Integer kCal) {
        this.kCal = kCal;
    }

    public void setNutritionalValues(HashMap<String, Double> nutritionalValues) {
        this.nutritionalValues = nutritionalValues;
    }

}
