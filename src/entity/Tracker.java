package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is the Tracker class to keep record of the user's food and water intake.
 */
public class Tracker {
    // Lists to track your food and water diaries.
    public List<Food> foodDiary;
    public List<Float> waterDiary;

    // HashMap to store nutritional values.
    public HashMap<String, Float> nutritionalValues = new HashMap<>();

    /**
     * Constructor to initialize your diaries and nutritional values.
     */
    public Tracker(){
        this.foodDiary = new ArrayList<>();
        this.waterDiary = new ArrayList<>();

        // Create Nutritional Values HashMap with initial values set to 0.0.
        this.nutritionalValues.put("Calories", 0.0F);
        this.nutritionalValues.put("Protein", 0.0F);
        this.nutritionalValues.put("Fat", 0.0F);
        this.nutritionalValues.put("Carbs", 0.0F);
    }

    /**
     * Get the total calories consumed.
     */
    public Float getTotalCalories() {
        return this.nutritionalValues.get("Calories");
    }

    /**
     * Get the water diary.
     */
    public List<Float> getWaterDiary() {
        return this.waterDiary;
    }

    /**
     * Get the food diary.
     */
    public List<Food> getDiary() {
        return this.foodDiary;
    }

    /**
     * Update the quantity of a specific food entry.
     * If the food is not in the diary, add it.
     */
    public void updateFoodEntry(String updatedFoodEntry, Float newAmount) {
        Food food = new Food(updatedFoodEntry, newAmount);
        if (this.foodDiary.contains(food)) {
            int i = foodDiary.indexOf(food);
            foodDiary.get(i).updateQuantity(newAmount);
        }
    }

    /**
     * Add water to your water diary.
     */
    public void addWater(float quantity) {
        this.waterDiary.add(quantity);
    }

    /**
     * Get the total nutritional values.
     */
    public HashMap<String, Float> getTotalNutrition() {
        return nutritionalValues;
    }

    /**
     * Add a food entry to your food diary and update nutritional values.
     */
    public void addFood(Food food) {
        foodDiary.add(food);
        updateNutritionalValues(food);
    }

    /**
     * Update nutritional values based on the added food entry.
     */
    private void updateNutritionalValues(Food food) {
        // Updating Calories, Protein, Fat, and Carbs.
        nutritionalValues.put("Calories", nutritionalValues.get("Calories") + food.getCalories());
        nutritionalValues.put("Protein", nutritionalValues.get("Protein") + food.getProtein());
        nutritionalValues.put("Fat", nutritionalValues.get("Fat") + food.getFat());
        nutritionalValues.put("Carbs", nutritionalValues.get("Carbs") + food.getCarbs());
    }

    /**
     * Check if the food diary is empty.
     */
    public boolean isEmpty() {
        return this.foodDiary.isEmpty();
    }

    /**
     * Clear contents of food diary
     */
    public void clear(){
        this.nutritionalValues.clear();
    }

    /**
     * Set the total nutritional values of the tracker's contents
     */
    public void setNutritionalValues(HashMap<String, Float> nutritionalValues) {
        this.nutritionalValues = nutritionalValues;
    }

    /**
     * Set the contents of the water diary
     */
    public void setWaterDiary(List<Float> waterDiary) {
        this.waterDiary = waterDiary;
    }

    /**
     * Set the contents of the food diary
     */
    public void setFoodDiary(List<Food> foodDiary) {
        this.foodDiary = foodDiary;
    }

    public boolean isHighProtein(){return this.nutritionalValues.get("Protein") > 120.0F;
    }

    public boolean isLowCarb(){return this.nutritionalValues.get("Carbs") < 40.0F;
    }

}


