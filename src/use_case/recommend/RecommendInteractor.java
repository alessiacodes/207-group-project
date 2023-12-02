package use_case.recommend;

import entity.Recommend;

import java.util.ArrayList;

public class RecommendInteractor implements RecommendInputBoundary{

    final RecommendDataAccessInterface recommendDataAccessObject;

    final RecommendOutputBoundary recommendPresenter;


    public RecommendInteractor(RecommendDataAccessInterface recommendDataAccessObject, RecommendOutputBoundary recommendPresenter){
        this.recommendDataAccessObject = recommendDataAccessObject;
        this.recommendPresenter = recommendPresenter;
    }



    @Override
    public void execute(RecommendInputData inputData) {
        ArrayList<String> diet = inputData.getDiet();
        ArrayList<String> health = inputData.getHealth();
        String mealType = inputData.getMealType();

        Recommend recommend = new Recommend(diet, health, mealType);

        String recommendLink = recommendDataAccessObject.getRecommendLink(recommend);

        RecommendOutputData recommendOutputData = new RecommendOutputData(recommendLink);

        recommendPresenter.prepareSuccessView(recommendOutputData);

    }
}
