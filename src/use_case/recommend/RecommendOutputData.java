package use_case.recommend;

import java.util.ArrayList;

public class RecommendOutputData {

    private final ArrayList<String> recommendations; //not sure if this would be strings


    public RecommendOutputData(ArrayList<String> recommendations){
        this.recommendations = recommendations;
    }


    public ArrayList<String> getRecommendations(){
        return recommendations;
    }

}
