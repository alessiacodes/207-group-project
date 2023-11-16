package entity;

import java.util.LinkedHashMap;

public class Food {

    private String name;
    private float quantity;
    private int kcal;
    private LinkedHashMap<String, Double> nutritionalValues;

    private float protein;
    private float fat;
    private float carbs;


    // TODO add API call for Edamam -> specify output of API data
    public Food(String name, float quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public int getCalories(){
        return kcal;
    }

    public void updateQuantity(float amount){
        this.quantity = amount;
    }

    public LinkedHashMap<String, Double> getNutritionalValues() {
        return nutritionalValues;
    }

    public Float getProtein() {
        return this.protein;
    }

    public Float getFat() {
        return this.fat;
    }

    public Float getCarbs() {
        return this.carbs;
    }
}