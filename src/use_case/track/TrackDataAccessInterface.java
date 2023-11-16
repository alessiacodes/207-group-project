package use_case.track;

import entity.Food;

import java.util.List;

public interface TrackDataAccessInterface {

    // Retrieve the current food diary
    List<Food> getFoodDiary();

    // Add a new entry to the food diary
    void addFoodEntry(Food foodEntry);

    // Update an existing entry in the food diary
    void updateFoodEntry(Food updatedFoodEntry, float newAmount);

    // Remove an entry from the food diary
    void deleteLastFoodEntry(Food foodEntry);
}
