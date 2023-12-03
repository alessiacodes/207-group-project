package use_case.track;

import java.util.HashMap;

public interface TrackDataAccessInterface {

    // Gets complete nutrition of food diary
    HashMap<String, Float> getFoodNutritionalValues(String foodName, Float quantity);

    Integer getFoodCalories(String foodName, Float quantity);


}
