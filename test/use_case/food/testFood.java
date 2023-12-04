package use_case.food;

import java.util.HashMap;

public class testFood {
    public static void main(String[] args) {
        ;
    }

}

class FakeDAO implements FoodDataAccessInterface{

    @Override
    public HashMap<String, Float> getFoodNutritionalValues(String foodName, Float quantity) {
        return null;
    }

    @Override
    public Integer getFoodCalories(String foodName, Float quantity) {
        return null;
    }
}
