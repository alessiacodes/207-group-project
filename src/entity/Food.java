package entity;

import java.util.HashMap;
import java.util.Objects;

public class Food {

    private String name;
    private float quantity;
    private int kcal;

    private final float protein;
    private final float fat;
    private final float carbs;

    private final HashMap<String, Float> nutritionalValues;


    // TODO add API call for Edamam -> specify output of API data
    public Food(String name, float quantity){
        this.name = name;
        this.quantity = quantity;
        this.nutritionalValues = new HashMap<String, Float>();

        // TODO update kcal and macro attributes to contain values from API instead of 0
        this.kcal = 0;
        this.protein = 0.0F;
        this.fat = 0.0F;
        this.carbs = 0.0F;

        // Create Nutritional Values HashMap
        this.nutritionalValues.put("Calories", (float) this.kcal);
        this.nutritionalValues.put("Protein", this.protein);
        this.nutritionalValues.put("Fat", this.fat);
        this.nutritionalValues.put("Carbs", this.carbs);
    }

    public String getName() {return name;}

    public int getCalories(){
        return kcal;
    }

    public void updateQuantity(float amount){
        this.quantity = amount;
    }

    public HashMap<String, Float> getNutritionalValues() {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Food food = (Food) obj;
        return Objects.equals(name, food.name);
    }

}