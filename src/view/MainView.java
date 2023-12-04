package view;

import use_case.food.FoodController;
import use_case.food.FoodViewModel;
import use_case.login.LoginController;
import use_case.login.LoginViewModel;
import use_case.recipe.RecipeController;
import use_case.recipe.RecipeViewModel;
import use_case.recommend.RecommendController;
import use_case.recommend.RecommendViewModel;
import use_case.signup.SignupController;
import use_case.signup.SignupViewModel;
import use_case.track.TrackController;
import use_case.track.TrackViewModel;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    // Some class constants,  i.e. the reference names for each panel card
    public final String LOGIN_PANEL_NAME = "loginPanel";
    public final String SIGNUP_PANEL_NAME = "signupPanel";
    public final String HOME_SCREEN_PANEL_NAME = "homeScreenPanel";
    public final String RECOMMEND_PANEL_NAME = "recommendPanel";
    public final String LOOKUP_VIEW_PANEL_NAME = "foodLookupPanel";
    public final String RECIPE_VIEW_PANEL_NAME = "recipe_view_panel";
    private JPanel parentPanel;
    private CardLayout cardLayout;
    private HomeScreenView homeScreenView;

    // view models and controllers
    private final SignupViewModel signupViewModel;
    private final SignupController signupController;
    private final RecommendViewModel recommendViewModel;
    private final RecommendController recommendController;
    private final FoodViewModel foodViewModel;
    private final FoodController foodController;
    private final TrackViewModel trackViewModel;
    private final TrackController trackController;
    private final LoginViewModel loginViewModel;
    private final LoginController loginController;
    private final RecipeViewModel recipeViewModel;
    private final RecipeController recipeController;



    //TODO remove if this doesn't cause issues, uncomment if it does
//    private JTextField nameTextField;
//    private JTextField usernameTextField2;
//    //private CardLayout cardLayout = (CardLayout)parentPanel.getLayout();



//    public static void main(String[] args) {
//        MainView view = new MainView(signupViewModel, signupController);
//    }
    public MainView(SignupViewModel signupViewModel, SignupController signupController, RecommendViewModel recommendViewModel,
                    RecommendController recommendController, FoodViewModel foodViewModel, FoodController foodController, TrackViewModel trackViewModel, TrackController trackController, LoginViewModel loginViewModel, LoginController loginController, RecipeViewModel recipeViewModel, RecipeController recipeController){
        this.signupViewModel = signupViewModel;
        this.signupController = signupController;
        this.recommendController = recommendController;
        this. recommendViewModel = recommendViewModel;
        this.foodViewModel = foodViewModel;
        this.foodController = foodController;
        this.trackViewModel = trackViewModel;
        this.trackController = trackController;
        this.loginViewModel = loginViewModel;
        this.loginController = loginController;
        this.recipeViewModel = recipeViewModel;
        this.recipeController = recipeController;

        this.setUpMainView();
    }

    public void setUpMainView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MARVN: Your Virtual Fitness Assistant");
        this.setSize(1920,1080);
        this.setLocationRelativeTo(null);
        this.add(parentPanel);
        ImageIcon marvnLogo = new ImageIcon("MARVN logo.png");
        this.setIconImage(marvnLogo.getImage());

        // Instantiate the subviews
        LoginView loginView = new LoginView(this, loginViewModel, loginController);
        SignupView signupView = new SignupView(this, signupController, signupViewModel);
        homeScreenView = new HomeScreenView(this);
        RecommendView recommendView = new RecommendView(this, recommendViewModel, recommendController);
        LookUpView lookUpView = new LookUpView(this, foodViewModel, foodController, trackViewModel, trackController);
        RecipeView recipeView = new RecipeView(this, recipeController, recipeViewModel);

        // Add them to the card layout
        parentPanel.add(loginView.getPanel(), LOGIN_PANEL_NAME);
        parentPanel.add(signupView.getSignupPanel(), SIGNUP_PANEL_NAME);
        parentPanel.add(homeScreenView.getHomeScreenPanel(), HOME_SCREEN_PANEL_NAME);
        parentPanel.add(recommendView.getRecommendViewPanel(), RECOMMEND_PANEL_NAME);
        parentPanel.add(lookUpView.getLookupPanel(), LOOKUP_VIEW_PANEL_NAME);
        parentPanel.add(recipeView.getMainPanel(), RECIPE_VIEW_PANEL_NAME);
        cardLayout  = (CardLayout) parentPanel.getLayout();
        swapCard(RECIPE_VIEW_PANEL_NAME);
        this.setVisible(true);
    }

    public HomeScreenView getHomeScreenView() {
        return homeScreenView;
    }

    public void swapCard(String cardName){
        cardLayout.show(parentPanel,cardName);
        System.out.println("swapped to "+ cardName);
    }
}
