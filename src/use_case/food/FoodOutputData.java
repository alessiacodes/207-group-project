package use_case.food;

import entity.Food;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FoodOutputData {

    private final String foodName;

    private final HashMap<String, Double> nutritionalValues;

    private final Integer kCal;

    public FoodOutputData(String foodName,
                          HashMap<String, Double> nutritionalValues,
                          Integer kCal)
    {
        this.foodName = foodName;
        this.nutritionalValues = nutritionalValues;
        this.kCal = kCal;
    }

    public String getFoodName() {return this.foodName;}
    public HashMap<String, Double> getNutritionalValues() {return this.nutritionalValues;}

    public Integer getKcal() {return this.kCal;};
}
