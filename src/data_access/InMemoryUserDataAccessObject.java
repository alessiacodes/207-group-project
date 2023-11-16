package data_access;

import entity.Food;
import entity.Tracker;
import entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import use_case.track.TrackDataAccessInterface;

// This is the Data Access object that will be used by the Interactor to retrieve Entity data

public class InMemoryUserDataAccessObject implements TrackDataAccessInterface {

    private final List<Food> foodDiary;

    InMemoryUserDataAccessObject(){
        this.foodDiary = new ArrayList<>();
    }

    /**
     * @return the food diary of the user
     */
    @Override
    public List<Food> getFoodDiary() { return foodDiary; }

    @Override
    public void addFoodEntry(Food foodEntry) {
        this.foodDiary.add(foodEntry);
    }

    @Override
    public void updateFoodEntry(Food updatedFoodEntry, float newAmount) {
        if (this.foodDiary.contains(updatedFoodEntry)){
            int i = foodDiary.indexOf(updatedFoodEntry);
            foodDiary.get(i).updateQuantity(newAmount);
        }
    }

    @Override
    public void deleteLastFoodEntry(Food foodEntry) {
        if (!this.foodDiary.isEmpty()) {
            this.foodDiary.remove(this.foodDiary.size() - 1);
        }
    }

    public Map<String, Float> getMacros(){
        Map<String, Float> macros = new HashMap<String, Float>();
        macros.put("Protein", (float) 0);
        macros.put("Fat", (float) 0);
        macros.put("Carbs", (float) 0);
        for (Food food : foodDiary){
            macros.put("Protein", macros.get("Protein") + food.getProtein());
            macros.put("Fat", macros.get("Fat") + food.getFat());
            macros.put("Carbs", macros.get("Carbs") + food.getCarbs());
        }
        return macros;
    };
}