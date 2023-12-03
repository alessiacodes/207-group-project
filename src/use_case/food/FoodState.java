package use_case.food;

import java.util.HashMap;

public class FoodState {

    private String foodName;
    private Float quantity;
    private Integer kCal;

    private HashMap<String, Float> nutritionalValues;

    public FoodState(FoodState foodState) {
        foodName = foodState.foodName;
        quantity = foodState.quantity;
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

    public Float getQuantity() {
        return quantity;
    }

    public HashMap<String, Float> getNutritionalValues() {

        return nutritionalValues;
    };


    //    Setters for the Food State

    public void setFoodName(String foodName) {

        this.foodName = foodName;
    }

    public void setkCal(Integer kCal) {

        this.kCal = kCal;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public void setNutritionalValues(HashMap<String, Float> nutritionalValues) {
        this.nutritionalValues = nutritionalValues;
    }

}
