package entity;

import java.util.List;

public class Tracker {
    private List<Food> foodDiary;
    private List<Double> waterDiary;

    public double getTotalCalories(){
        int totalCals = 0;
        for (Food food: foodDiary){
            totalCals += food.getCalories();
        }

        return totalCals;
    }

    /* Returns the total nutrition of the whole diary based on a single nutritional value (i.e. returns all the protein
    from the whole diary.
    * */
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