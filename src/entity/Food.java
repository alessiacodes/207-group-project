package entity;

import java.util.LinkedHashMap;

public class Food {

    private String name;
    private float quantity;
    private int kcal;
    private LinkedHashMap<String, Double> nutritionalValues;


    // TODO add API call for Edamam -> specify output of API data
    public Food(String name, float quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {return name;}

    public int getCalories(){
        return kcal;
    }

    public LinkedHashMap<String, Double> getNutritionalValues() {
        return nutritionalValues;
    }

}