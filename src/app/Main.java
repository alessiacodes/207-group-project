package app;

import data_access.EdamamApiAccess;
import data_access.FileUserDataAccessObject;
import entity.BasicUserFactory;
import entity.Tracker;
import use_case.food.FoodController;
import use_case.food.FoodInteractor;
import use_case.food.FoodPresenter;
import use_case.food.FoodViewModel;
import use_case.login.LoginController;
import use_case.login.LoginInteractor;
import use_case.login.LoginPresenter;
import use_case.login.LoginViewModel;
import use_case.recipe.RecipeController;
import use_case.recipe.RecipeInteractor;
import use_case.recipe.RecipePresenter;
import use_case.recipe.RecipeViewModel;
import use_case.recommend.RecommendController;
import use_case.recommend.RecommendInteractor;
import use_case.recommend.RecommendPresenter;
import use_case.recommend.RecommendViewModel;
import use_case.signup.SignupController;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupPresenter;
import use_case.signup.SignupViewModel;
import use_case.track.*;
import view.MainView;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BasicUserFactory userFactory = new BasicUserFactory();
        FileUserDataAccessObject fileDAO = new FileUserDataAccessObject("users.csv", userFactory);
        EdamamApiAccess apiAccess = new EdamamApiAccess();


        SignupViewModel signupViewModel = new SignupViewModel();
        SignupPresenter signupPresenter = new SignupPresenter(signupViewModel);
        SignupInteractor signupInteractor = new SignupInteractor(fileDAO, signupPresenter, userFactory);
        SignupController signupController = new SignupController(signupInteractor);

        RecommendViewModel recommendViewModel = new RecommendViewModel();
        RecommendPresenter recommendPresenter = new RecommendPresenter(recommendViewModel);
        RecommendInteractor recommendInteractor = new RecommendInteractor(apiAccess, recommendPresenter);
        RecommendController recommendController = new RecommendController(recommendInteractor);

        FoodViewModel foodViewModel = new FoodViewModel();
        FoodPresenter foodPresenter = new FoodPresenter(foodViewModel);
        FoodInteractor foodInteractor = new FoodInteractor(apiAccess, foodPresenter);
        FoodController foodController = new FoodController(foodInteractor);

        TrackState trackState = new TrackState();
        TrackViewModel trackViewModel = new TrackViewModel(trackState);
        TrackPresenter trackPresenter = new TrackPresenter(trackViewModel);
        TrackInteractor trackInteractor = new TrackInteractor(apiAccess, trackPresenter);
        TrackController trackController = new TrackController(trackInteractor, new Tracker());

        LoginViewModel loginViewModel = new LoginViewModel();
        LoginPresenter loginPresenter = new LoginPresenter(loginViewModel);
        LoginInteractor loginInteractor = new LoginInteractor(fileDAO, loginPresenter);
        LoginController loginController = new LoginController(loginInteractor);

        RecipeViewModel recipeViewModel = new RecipeViewModel();
        RecipePresenter recipePresenter = new RecipePresenter(recipeViewModel);
        RecipeInteractor recipeInteractor = new RecipeInteractor(apiAccess, recipePresenter);
        RecipeController recipeController = new RecipeController(recipeInteractor);


        MainView mainView = new MainView(signupViewModel, signupController, recommendViewModel, recommendController, foodViewModel, foodController, trackViewModel, trackController, loginViewModel, loginController, recipeViewModel, recipeController);
    }
}


// Main class that starts the entire application
// 