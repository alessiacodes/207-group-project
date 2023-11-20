package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    private JPanel parentPanel;
    private JPanel loginPanel;
    private JTextField usernameTextField;
    private JPasswordField passwordPasswordField;
    private JButton signUpButton;
    private JButton loginButton;
    private JTextField textField1;
    private JPanel signupPanel;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox genderSelector;
    private JComboBox dietaryRestrictionChoices;
    //private CardLayout cardLayout = (CardLayout)parentPanel.getLayout();



    public static void main(String[] args) {
        MainView view = new MainView();
    }
    public MainView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MARVN: Your Virtual Fitness Assistant");
        this.setSize(1920,1080);
        this.setLocationRelativeTo(null);
        this.add(parentPanel);
        ImageIcon marvnLogo = new ImageIcon("MARVN logo.png");
        this.setIconImage(marvnLogo.getImage());
        parentPanel.add(loginPanel, "loginPanel");
        parentPanel.add(signupPanel, "signupPanel");
        CardLayout cardLayout  = (CardLayout) parentPanel.getLayout();
        cardLayout.show(parentPanel,"loginPanel");

        //combobox gender for signup panel editing
        genderSelector.addItem("Other");
        genderSelector.addItem("Male");
        genderSelector.addItem("Female");

        //combobox for dietary restrictions signup panel editing
        dietaryRestrictionChoices.addItem("None");
        dietaryRestrictionChoices.addItem("Vegetarian"); //TODO, make these correspond with edamam notation
        dietaryRestrictionChoices.addItem("Gluten Free");
        dietaryRestrictionChoices.addItem("Dairy Free");
        dietaryRestrictionChoices.addItem("Vegan");
        dietaryRestrictionChoices.addItem("Kosher");


        this.setVisible(true);

    }
}
