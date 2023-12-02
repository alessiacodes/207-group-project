package view;

import use_case.recommend.RecommendController;
import use_case.recommend.RecommendViewModel;
import use_case.signup.SignupController;
import use_case.signup.SignupViewModel;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    // Some class constants,  i.e. the reference names for each panel card
    public final String LOGIN_PANEL_NAME = "loginPanel";
    public final String SIGNUP_PANEL_NAME = "signupPanel";
    public final String HOME_SCREEN_PANEL_NAME = "homeScreenPanel";
    public final String RECOMMEND_PANEL_NAME = "recommendPanel";
    private JPanel parentPanel;
    private CardLayout cardLayout;

    // view models and controllers
    private final SignupViewModel signupViewModel;
    private final SignupController signupController;
    private final RecommendViewModel recommendViewModel;
    private final RecommendController recommendController;



    //TODO remove if this doesn't cause issues, uncomment if it does
//    private JTextField nameTextField;
//    private JTextField usernameTextField2;
//    //private CardLayout cardLayout = (CardLayout)parentPanel.getLayout();



//    public static void main(String[] args) {
//        MainView view = new MainView(signupViewModel, signupController);
//    }
    public MainView(SignupViewModel signupViewModel, SignupController signupController, RecommendViewModel recommendViewModel,
                    RecommendController recommendController){
        this.signupViewModel = signupViewModel;
        this.signupController = signupController;
        this.recommendController = recommendController;
        this. recommendViewModel = recommendViewModel;
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
        LoginView loginView = new LoginView(this);
        SignupView signupView = new SignupView(this, signupController, signupViewModel);
        HomeScreenView homeScreenView = new HomeScreenView(this);
        RecommendView recommendView = new RecommendView(this, recommendViewModel, recommendController);

        // Add them to the card layout
        parentPanel.add(loginView.getPanel(), LOGIN_PANEL_NAME);
        parentPanel.add(signupView.getSignupPanel(), SIGNUP_PANEL_NAME);
        parentPanel.add(homeScreenView.getHomeScreenPanel(), HOME_SCREEN_PANEL_NAME);
        parentPanel.add(recommendView.getRecommendViewPanel(), RECOMMEND_PANEL_NAME);
        cardLayout  = (CardLayout) parentPanel.getLayout();
        swapCard(HOME_SCREEN_PANEL_NAME);
        this.setVisible(true);
    }
    public void swapCard(String cardName){
        cardLayout.show(parentPanel,cardName);
        System.out.println("swapped to "+ cardName);
    }
}
