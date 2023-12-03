package view;

import use_case.login.LoginController;
import use_case.login.LoginState;
import use_case.login.LoginViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginView implements PropertyChangeListener {
    private JPanel oldPanel;
    private JTextField usernameTextField;
    private JButton signUpButton;
    private JPasswordField passwordPasswordField;
    private JButton loginButton;
    private JPanel loginPanel;
    private MainView mainView;
    private final LoginViewModel loginViewModel;
    private final LoginController loginController;

    public LoginView(MainView mainView, LoginViewModel loginViewModel, LoginController loginController){
        this.mainView = mainView;
        this.loginViewModel = loginViewModel;
        this.loginController = loginController;
        oldPanel.setSize(1920,1080);
        loginPanel.setSize(1920,1080);
        this.setUpPanel();

    }


    public JPanel getPanel(){
        return loginPanel;
    }

    private void setUpPanel(){
        loginViewModel.addPropertyChangeListener(this);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.swapCard(mainView.SIGNUP_PANEL_NAME);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usernameTextField.getText().equals("") || passwordPasswordField.getText().equals("")){
                    launchFailView("Error: blank text field");
                }
                else{
                    loginController.execute(usernameTextField.getText(), passwordPasswordField.getText());
                }
            }
        });
    }

    private void launchFailView(String failMessage){
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

    private void launchSuccessView(String successMessage){
        JFrame successPopUpWindow = new JFrame();
        successPopUpWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        successPopUpWindow.setTitle("Success: logged in!");
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoginState state = (LoginState) evt.getNewValue();
        if (state.getPasswordError() != null){
            launchFailView(state.getPasswordError());
            state.setPasswordError(null);
        }
        else if (state.getUsernameError() != null){
            launchFailView(state.getUsernameError());
            state.setUsernameError(null);
        }
        else {
            launchSuccessView("Successfully Logged in: Welcome to MARVN, " + state.getUsername());
            mainView.swapCard(mainView.HOME_SCREEN_PANEL_NAME);
        }

    }
}
