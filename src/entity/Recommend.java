package entity;

import java.util.ArrayList;

public class Recommend {

    private ArrayList<String> diet;

    private ArrayList<String> health;

    private String mealType;

    public Recommend(ArrayList<String> diet, ArrayList<String> health, String mealType){
        this.diet = diet;
        this.health = health;
        this.mealType = mealType;
    }


    public ArrayList<String> getDiet(){
        return diet;
    }

    public ArrayList<String> getHealth(){
        return health;
    }

    public String getMealType(){
        return mealType;
    }

    public void setDiet(ArrayList<String> diet){
        this.diet = diet;
    }

    public void setHealth(ArrayList<String> health){

        this.health = health;
    }

    public void setMealType(String mealType){

        this.mealType = mealType;
    }

}
