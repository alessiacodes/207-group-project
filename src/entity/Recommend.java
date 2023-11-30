package entity;

import java.util.ArrayList;

public class Recommend {

    private final ArrayList<String> diet;

    private final ArrayList<String> health;

    private final String mealType;

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

}
