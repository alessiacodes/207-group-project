package use_case.food;

import java.util.HashMap;

public class FoodOutputData {

    private final String foodName;

    private final HashMap<String, Float> nutritionalValues;

    private Float quantity;

    private final Integer kCal;

    public FoodOutputData(String foodName,
                          Float quantity,
                          HashMap<String, Float> nutritionalValues,
                          Integer kCal)
    {
        this.foodName = foodName;
        this.quantity = quantity;
        this.nutritionalValues = nutritionalValues;
        this.kCal = kCal;
    }

    public String getFoodName() {
        return this.foodName;
    }

    public Float getQuantity() {
        return this.quantity;
    }
    public HashMap<String, Float> getNutritionalValues() {
        return this.nutritionalValues;
    }

    public Integer getKcal() {
        return this.kCal;
    };
}
