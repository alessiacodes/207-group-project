package use_case.recommend;

import java.util.ArrayList;

public interface RecommendDataAccessInterface {
    //TODO might need more functions here
    ArrayList<String> getMealList(String diet, String health, String mealType);

}
