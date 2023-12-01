package view;

import use_case.signup.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class SignupView implements PropertyChangeListener {
    private JPanel signupPanel;
    private JTextField nameTextField;
    private JTextField usernameTextField2;
    private JTextField passwordTextField;
    private JComboBox genderSelector;
    private JComboBox dietaryRestrictionChoices;
    private JPanel oldPanel;
    private JTextField weightTextField;
    private JTextField ageTextField;
    private JTextField heightTextField;
    private JButton clickHereToSubmitButton;
    private JButton backButton;
    private MainView mainView;
    private final SignupController signupController;
    private final SignupViewModel signupViewModel;

    public SignupView(MainView mainView, SignupController signupController, SignupViewModel signupViewModel){
        this.mainView = mainView;
        this.signupController = signupController;
        this.signupViewModel = signupViewModel;
        this.signupViewModel.addPropertyChangeListener(this);

        this.setUpPanel();
    }

    public JPanel getSignupPanel() {
        return signupPanel;
    }

    public void launchSuccessView(String successMessage){
        JFrame successPopUpWindow = new JFrame();
        successPopUpWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        successPopUpWindow.setTitle("Success: user created!");
        successPopUpWindow.setSize(600,500);

        JLabel message = new JLabel();
            message.setText(successMessage);
            message.setHorizontalAlignment(SwingConstants.CENTER);
            message.setVerticalAlignment(SwingConstants.CENTER);
            Font font = message.getFont();
            message.setFont(new Font(font.getName(), Font.PLAIN, 20));

        successPopUpWindow.add(message);
        successPopUpWindow.setLocationRelativeTo(null);
        successPopUpWindow.setVisible(true);

    }

    public void launchFailView(String failMessage){
        JFrame successPopUpWindow = new JFrame();
        successPopUpWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        successPopUpWindow.setTitle("Error :(");
        successPopUpWindow.setSize(600,500);

        JLabel message = new JLabel();
        message.setText(failMessage);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setVerticalAlignment(SwingConstants.CENTER);
        Font font = message.getFont();
        message.setFont(new Font(font.getName(), Font.PLAIN, 20));

        successPopUpWindow.add(message);
        successPopUpWindow.setLocationRelativeTo(null);
        successPopUpWindow.setVisible(true);
    }

    private void setUpPanel(){

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

        clickHereToSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO implement that users can choose more than 1 dietary restriction
                ArrayList<String> dietaryRestrictions = new ArrayList<>();
                dietaryRestrictions.add(dietaryRestrictionChoices.getName());

                // TODO remove after testing
                System.out.println(dietaryRestrictionChoices.getSelectedItem());
                System.out.println(usernameTextField2.getText());
                System.out.println(passwordTextField.getText());
                System.out.println(nameTextField.getText());
                System.out.println(ageTextField.getText());
                System.out.println(genderSelector.getSelectedItem());
                System.out.println(heightTextField.getText());
                System.out.println(weightTextField.getText());

                try {
                    signupController.execute(usernameTextField2.getText(),
                            passwordTextField.getText(),
                            nameTextField.getText(),
                            genderSelector.getName(),
                            Integer.parseInt(ageTextField.getText()),
                            Double.parseDouble(heightTextField.getText()),
                            dietaryRestrictions,
                            Double.parseDouble(weightTextField.getText()));
                }   catch (NumberFormatException error){
                    launchFailView("Error: Please input an appropriate number in the number fields");
                }


            }

        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.swapCard(mainView.LOGIN_PANEL_NAME);
            }
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        SignupState state  = (SignupState) evt.getNewValue();
        if (state.getCurrentErrorMessage() != null){
            launchFailView(state.getCurrentErrorMessage());
            signupViewModel.getState().setCurrentErrorMessage(null); // reset so there's no error
        }
        else{ // successfully signed up!
            launchSuccessView(state.getCurrentSuccessMessage());
            mainView.swapCard(mainView.LOGIN_PANEL_NAME);
        }

    }
}
