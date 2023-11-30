package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView {
    private JPanel oldPanel;
    private JTextField usernameTextField;
    private JButton signUpButton;
    private JPasswordField passwordPasswordField;
    private JButton loginButton;
    private JPanel loginPanel;
    private MainView mainView;

    public LoginView(MainView mainView){
        this.mainView = mainView;
        oldPanel.setSize(1920,1080);
        loginPanel.setSize(1920,1080);
        this.setUpPanel();

    }


    public JPanel getPanel(){
        return loginPanel;
    }

    private void setUpPanel(){
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.swapCard(mainView.SIGNUP_PANEL_NAME);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO implement
            }
        });
    }
}
