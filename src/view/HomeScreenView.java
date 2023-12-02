package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreenView {
    private final MainView mainView;
    private JPanel homeScreenPanel;
    private JLabel logoImageLabel;
    private JPanel leftTrackerSpacePanel;
    private JPanel trackerTextPanel;
    private JLabel TrackerTitle;
    private JPanel totalMarcosPanel;
    private JPanel putFoodHerePanel;
    private JPanel titleAndButtonsPanel;
    private JButton addFoodToTrackerButton;
    private JLabel totalCaloriesLabel;
    private JLabel totalCarbsLabel;
    private JLabel totalProteinLabel;
    private JLabel totalFatLabel;
    private JButton calculateCaloriesInRecipeButton;
    private JButton recommendARecipeButton;
    private JButton lookUpFoodButton;

    public HomeScreenView(MainView mainView){
        this.mainView = mainView;
        homeScreenPanel.setSize(1920,1080);
        setUpPanel();


    }

    public JPanel getHomeScreenPanel() {
        return homeScreenPanel;
    }

    private void setUpPanel(){

        ImageIcon icon = new ImageIcon("C:\\Users\\allyr\\IdeaProjects\\Labs\\Lab2\\MARVN-Your-Virtual-Fitness-Assistant\\src\\view\\MARVN logo.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        logoImageLabel.setIcon(scaledIcon);
        putFoodHerePanel.setLayout(new BoxLayout(putFoodHerePanel, BoxLayout.Y_AXIS));

        // BUTTONS!
        addFoodToTrackerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        calculateCaloriesInRecipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        recommendARecipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        lookUpFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void addFoodToTrackerView(String foodAndMacros){
        JLabel newFood = new JLabel(foodAndMacros);
        Font font = new Font(newFood.getFont().getFontName(), Font.PLAIN, 20);
        newFood.setFont(font);
        newFood.setHorizontalAlignment(SwingConstants.LEFT);
        putFoodHerePanel.add(newFood);
    }
}
