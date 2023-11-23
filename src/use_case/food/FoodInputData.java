package use_case.food;

import java.util.LinkedHashMap;

public class FoodInputData {

    final private String name;
    final private float quantity;
    final private int kcal;
    final private LinkedHashMap<String, Double> nutritionalValues;

    public FoodInputData(String name, float quantity, int kcal, LinkedHashMap<String, Double> nutritionalValues) {
        this.name = name;
        this.quantity = quantity;
        this.kcal = kcal;
        this.nutritionalValues = nutritionalValues;
    }

    String getFoodName() {return name;};
    float getFoodQuantity() {return quantity;};
    int getFoodKcal() {return kcal;};
    LinkedHashMap<String, Double > getFoodNutritionalValues() {return nutritionalValues;};

}
