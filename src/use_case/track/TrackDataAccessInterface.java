package use_case.track;

import entity.Food;

import java.util.List;
import java.util.Map;

public interface TrackDataAccessInterface {

    // Retrieve the current food diary
    List<Food> getFoodDiary();

    // Add a new entry to the food diary
    void addFoodEntry(Food foodEntry);

    // Update an existing entry in the food diary
    void updateFoodEntry(String updatedFoodEntry, float newAmount);

    // Remove an entry from the food diary
    void removeFood(Food foodEntry);

    // Gets complete nutrition of food diary
    Map<String, Float> getTotalNutrition();


}
