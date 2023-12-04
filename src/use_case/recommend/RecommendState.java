package use_case.recommend;

import java.util.ArrayList;

public class RecommendState {
    // Attributes for popups
    private ArrayList<String> diet;
    private ArrayList<String> health;
    private String mealType;

    private String recommendLink;
    private String currentErrorMessage = null;
    private String currentSuccessMessage = null;


    public RecommendState(RecommendState copy) {
        diet = copy.diet;
        health = copy.health;
        mealType = copy.mealType;
        currentErrorMessage = copy.currentErrorMessage;
        currentSuccessMessage = copy.currentSuccessMessage;
    }

    public RecommendState(){

    }

    public ArrayList<String> getDiet() {
        return diet;
    }

    public ArrayList<String> getHealth() {
        return health;
    }

    public String getMealType() {
        return mealType;
    }

    public String getRecommendLink() {
        return recommendLink;
    }

    public String getCurrentErrorMessage() {
        return currentErrorMessage;
    }

    public String getCurrentSuccessMessage() {
        return currentSuccessMessage;
    }

    public void setDiet(ArrayList<String> diet) {
        this.diet = diet;
    }

    public void setHealth(ArrayList<String> health) {
        this.health = health;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public void setRecommendLink(String recommendLink) {
        this.recommendLink = recommendLink;
    }

    public void setCurrentErrorMessage(String currentErrorMessage) {
        this.currentErrorMessage = currentErrorMessage;
    }

    public void setCurrentSuccessMessage(String currentSuccessMessage) {
        this.currentSuccessMessage = currentSuccessMessage;
    }

}
