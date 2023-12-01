package data_access;

import entity.Food;
import entity.Tracker;
import entity.User;

import java.util.List;
import java.util.Map;

import use_case.track.TrackDataAccessInterface;

// This is the Data Access object that will be used by the TrackInteractor to retrieve Tracker data.
// It contains functionality to add, update, and remove entries from the food diary.
// One may also extract the sum of the nutritional values of all the entries in the food diary.

public class InMemoryUserDataAccessObject implements TrackDataAccessInterface {

    private final Tracker tracker;

    InMemoryUserDataAccessObject(Tracker tracker){
        this.tracker = tracker;
    };

    /**
     * @return the user's food diary
     **/
    @Override
    public List<Food> getFoodDiary() { return tracker.getDiary(); }

    /**
     * Adds an entry to food diary
     **/
    @Override
    public void addFoodEntry(Food foodEntry) {
        this.tracker.addFood(foodEntry);
    }


    /**
     * @param user the data to save
     */

    public void save(User user) {
        users.put(user.getName(), user);
=======

    /**
     * Updates a food entry with a new amount
     **/
    @Override
    public void updateFoodEntry(String updatedFoodEntry, float newAmount) {
        Food food = new Food(updatedFoodEntry, newAmount);
        this.tracker.updateFoodEntry(updatedFoodEntry, newAmount);
    }

    /**
     * Removes a food entry
     **/
    @Override
    public void removeFood(Food foodEntry) {
        this.tracker.removeFood(foodEntry);
    }

    /**
     * Gets the total nutrition from the tracker (i.e, the sum of the nutritional values of all the entries)
     **/
    @Override
    public Map<String, Float> getTotalNutrition() {
        return this.tracker.getTotalNutrition();
    }

}