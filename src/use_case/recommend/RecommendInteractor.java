package use_case.recommend;

import entity.Recommend;

import java.util.ArrayList;

public class RecommendInteractor implements RecommendInputBoundary{

    //used to get link to recipe from edamam api
    final RecommendDataAccessInterface recommendDataAccessObject;

    final RecommendOutputBoundary recommendPresenter;


    public RecommendInteractor(RecommendDataAccessInterface recommendDataAccessObject, RecommendOutputBoundary recommendPresenter){
        this.recommendDataAccessObject = recommendDataAccessObject;
        this.recommendPresenter = recommendPresenter;
    }



    @Override
    public void execute(RecommendInputData inputData) {
        // create recommend object using user input data
        ArrayList<String> diet = inputData.getDiet();
        ArrayList<String> health = inputData.getHealth();
        String mealType = inputData.getMealType();
        Recommend recommend = new Recommend(diet, health, mealType);

        // get link to recipe using data in recommend object
        String recommendLink = recommendDataAccessObject.getRecommendLink(recommend);

        RecommendOutputData recommendOutputData = new RecommendOutputData(recommendLink);

        // update view
        recommendPresenter.prepareSuccessView(recommendOutputData);

    }
}
