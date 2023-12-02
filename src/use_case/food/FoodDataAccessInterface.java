package use_case.food;

import java.util.HashMap;

public interface FoodDataAccessInterface {

    HashMap<String, Double> getFoodNutritionalValues(String foodName, Float quantity);

    Integer getFoodCalories(String foodName, Float quantity);
//    To-do: Decide whether the calory related data is necessary
//    int getCalories(String foodName, Float Quantity);

}
