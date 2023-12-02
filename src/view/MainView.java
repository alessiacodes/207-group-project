package view;

import use_case.signup.SignupController;
import use_case.signup.SignupViewModel;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    // Some class constants,  i.e. the reference names for each panel card
    public final String LOGIN_PANEL_NAME = "loginPanel";
    public final String SIGNUP_PANEL_NAME = "signupPanel";
    private JPanel parentPanel;
    private CardLayout cardLayout;

    // view models and controllers
    private final SignupViewModel signupViewModel;
    private final SignupController signupController;



    //TODO remove if this doesn't cause issues, uncomment if it does
//    private JTextField nameTextField;
//    private JTextField usernameTextField2;
//    //private CardLayout cardLayout = (CardLayout)parentPanel.getLayout();



//    public static void main(String[] args) {
//        MainView view = new MainView(signupViewModel, signupController);
//    }
    public MainView(SignupViewModel signupViewModel, SignupController signupController){
        this.signupViewModel = signupViewModel;
        this.signupController = signupController;
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

        LoginView loginView = new LoginView(this);
        SignupView signupView = new SignupView(this, signupController, signupViewModel);

        parentPanel.add(loginView.getPanel(), "loginPanel");
        parentPanel.add(signupView.getSignupPanel(), "signupPanel");
        cardLayout  = (CardLayout) parentPanel.getLayout();
        swapCard("loginPanel");
        this.setVisible(true);
    }
    public void swapCard(String cardName){
        cardLayout.show(parentPanel,cardName);
        System.out.println("swapped to "+ cardName);
    }
}
