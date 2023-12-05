package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tracker {
    public List<Food> foodDiary;
    public List<Float> waterDiary;

    public HashMap<String, Float> nutritionalValues = new HashMap<>();

    public Tracker(){
        this.foodDiary = new ArrayList<Food>();
        this.waterDiary = new ArrayList<Float>();

        // Create Nutritional Values HashMap
        this.nutritionalValues.put("Calories", 0.0F);
        this.nutritionalValues.put("Protein", 0.0F);
        this.nutritionalValues.put("Fat", 0.0F);
        this.nutritionalValues.put("Carbs", 0.0F);
    }

    public Float getTotalCalories(){return this.nutritionalValues.get("Calories");}

    public List<Float> getWaterDiary(){return this.waterDiary;}

    public List<Food> getDiary(){
        return this.foodDiary;
    }

    public void updateFoodEntry(String updatedFoodEntry, Float newAmount){
        Food food = new Food(updatedFoodEntry, newAmount);
        if (this.foodDiary.contains(food)){
            int i = foodDiary.indexOf(food);
            foodDiary.get(i).updateQuantity(newAmount);
        }
    }

    public void addWater(float quantity){
        this.waterDiary.add(quantity);
    }

    public HashMap<String, Float> getTotalNutrition() {
        return nutritionalValues;
    }

    public void addFood(Food food){
        foodDiary.add(food);
        updateNutritionalValues(food);
    }

    private void updateNutritionalValues(Food food) {
        // Updating Calories
        float currentValueCal = nutritionalValues.get("Calories");
        float newValueCal = currentValueCal + food.getCalories();
        nutritionalValues.put("Calories", newValueCal);

        float currentValueProtein = nutritionalValues.get("Protein");
        float newValueProtein = currentValueProtein + food.getProtein();
        nutritionalValues.put("Protein", newValueProtein);

        float currentValueFat = nutritionalValues.get("Fat");
        float newValueFat = currentValueFat + food.getFat();
        nutritionalValues.put("Fat", newValueFat);

        float currentValueCarbs = nutritionalValues.get("Carbs");
        float newValueCarb = currentValueCarbs + food.getCarbs();
        nutritionalValues.put("Carbs", newValueCarb);
    }

    public boolean isEmpty(){
        return this.foodDiary.isEmpty();
    }

}