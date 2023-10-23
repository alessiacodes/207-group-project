package entity;

import java.util.List;

public class FoodTracker {
    private List<Food> foodDiary;
    private List<Double> waterDiary;

    public double getTotalCalories(){
        int totalCals = 0;
        for (Food food: foodDiary){
            totalCals += food.getCalories();
        }

        return totalCals;
    }

    public double getTotalNutrition(String nutrient){
        int totalNutrients = 0;
        for (Food food: foodDiary){
            totalNutrients += food.getNutritionalValues().get(nutrient);
        }

        return totalNutrients;
    }

    public void addFood(Food food){
        foodDiary.add(food);
    }

    public void removeFood(Food food){
        foodDiary.remove(food);
    }

}