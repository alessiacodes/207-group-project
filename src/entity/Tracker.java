package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {
    private List<Food> foodDiary;
    private List<Double> waterDiary;

    private HashMap<String, Float> nutritionalValues;

    public Tracker(){
        this.foodDiary = new ArrayList<Food>();
        this.waterDiary = new ArrayList<Double>();

        // Create Nutritional Values HashMap
        this.nutritionalValues.put("Calories", 0.0F);
        this.nutritionalValues.put("Protein", 0.0F);
        this.nutritionalValues.put("Fat", 0.0F);
        this.nutritionalValues.put("Carbs", 0.0F);
    }

    public double getTotalCalories(){
        int totalCals = 0;
        for (Food food: foodDiary){
            totalCals += food.getCalories();
        }
        return totalCals;
    }

    public List<Double> getWaterDiary(){
        return this.waterDiary;
    }

    public List<Food> getDiary(){
        return this.foodDiary;
    }

    public void updateFoodEntry(Food updatedFoodEntry, Float newAmount){
        if (this.foodDiary.contains(updatedFoodEntry)){
            int i = foodDiary.indexOf(updatedFoodEntry);
            foodDiary.get(i).updateQuantity(newAmount);
        }
    }

    /* Returns the total nutrition of the whole diary based on a single nutritional value (i.e. returns all the protein
    from the whole diary.
    * */
    public double getNutrientContent(String nutrient){
        Float content = (float) 0;
        for (Food food: foodDiary){
            content += food.getNutritionalValues().get(nutrient);
        }
        return content;
    }

    public Map<String, Float> getTotalNutrition() {
        return nutritionalValues;
    }


    public void addFood(Food food){
        if (!foodDiary.contains(food)){
            foodDiary.add(food);
        }
    }

    public void removeFood(Food food){
        if (!this.foodDiary.isEmpty()) {
            this.foodDiary.remove(food);
        }
        System.out.println("Food not currently in diary.");
    }

    boolean isEmpty(){
        return this.foodDiary.isEmpty();
    }

}