package use_case.food;

import entity.Food;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FoodOutputData {

    private final String foodName;

    private final HashMap<String, Double> nutritionalValues;

    public FoodOutputData(String foodName,
                            HashMap<String, Double> nutritionalValues) {
        this.foodName = foodName;
        this.nutritionalValues = nutritionalValues;
    }

    public String getFoodName() {return this.foodName;}
    public HashMap<String, Double> getNutritionalValues() {return this.nutritionalValues;}

}
