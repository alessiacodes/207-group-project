package use_case.food;

import java.util.HashMap;

public interface FoodDataAccessInterface {

    HashMap<String, Double> getFoodNutritionalValues(String foodName, Float Quantity);
}
