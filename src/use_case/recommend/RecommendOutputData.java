package use_case.recommend;

import java.util.ArrayList;

public class RecommendOutputData {

    private final ArrayList<String> diet;

    private final ArrayList<String> health;

    private final String mealType;


    public RecommendOutputData(ArrayList<String> diet, ArrayList<String> health, String mealType){
        this.diet = diet;
        this.health = health;
        this.mealType = mealType;
    }

}
