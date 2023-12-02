package use_case.recommend;

import java.util.ArrayList;

public class RecommendController {
    final RecommendInputBoundary interactor;

    public RecommendController(RecommendInputBoundary interactor){
        this.interactor = interactor;
    }

    public void execute(ArrayList<String> diet, ArrayList<String> health, String mealType){
        RecommendInputData inputData = new RecommendInputData(diet, health, mealType);
        interactor.execute(inputData);
    }
}
