package use_case.food;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FoodInputData {

    final private String name;
    final private float quantity;

//    final private Integer kcal = null;
    final private LinkedHashMap<String, Double> nutritionalValues = null;

    public FoodInputData(String name, float quantity) {
        this.name = name;
        this.quantity = quantity;
//                this.calories = kcal;
    }

    String getFoodName() {return name;};
    float getFoodQuantity() {return quantity;};
    HashMap<String, Double > getFoodNutritionalValues() {return nutritionalValues;};

    //  To-do: review after discussing which type
    //  of HashMap to use throughout
    //  the whole project
    //
    //     LinkedHashMap<String, Double > getFoodNutritionalValues() {return nutritionalValues;};
    //  int getCalories() {return calories;};

}
