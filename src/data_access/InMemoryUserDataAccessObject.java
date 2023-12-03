package data_access;

import entity.Tracker;

import java.util.HashMap;

import use_case.track.TrackDataAccessInterface;

// This is the Data Access object that will be used by the TrackInteractor to retrieve Tracker data.
// It contains functionality to add, update, and remove entries from the food diary.
// One may also extract the sum of the nutritional values of all the entries in the food diary.

public class InMemoryUserDataAccessObject implements TrackDataAccessInterface {

    private final Tracker tracker;

    public InMemoryUserDataAccessObject(Tracker tracker){
        this.tracker = tracker;
    };

    /**
     * Gets the total nutrition from the tracker (i.e, the sum of the nutritional values of all the entries)
     **/
    @Override
    public HashMap<String, Float> getFoodNutritionalValues(String foodName, Float quantity) {
        return null;
    }

    @Override
    public Integer getFoodCalories(String foodName, Float quantity) {
        return null;
    }
}