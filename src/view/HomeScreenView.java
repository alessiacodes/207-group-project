package view;

import javax.swing.*;
import java.awt.*;

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

    public HomeScreenView(MainView mainView){
        this.mainView = mainView;
        homeScreenPanel.setSize(1920,1080);
        setUpPanel();

    }

    public JPanel getHomeScreenPanel() {
        return homeScreenPanel;
    }

    private void setUpPanel(){
//        ImageIcon imageLogo = new ImageIcon("C:\\Users\\allyr\\IdeaProjects\\Labs\\Lab2\\MARVN-Your-Virtual-Fitness-Assistant\\src\\view\\MARVN logo.png");
//        Image img = imageLogo.getImage();
//        Image scaledImg = img.getScaledInstance(300,300, Image.SCALE_DEFAULT);
//        ImageIcon scaledImgIcon = new ImageIcon(scaledImg);
//        logoImageLabel.setIcon(scaledImgIcon);

        ImageIcon icon = new ImageIcon("C:\\Users\\allyr\\IdeaProjects\\Labs\\Lab2\\MARVN-Your-Virtual-Fitness-Assistant\\src\\view\\MARVN logo.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        logoImageLabel.setIcon(scaledIcon);
        putFoodHerePanel.setLayout(new BoxLayout(putFoodHerePanel, BoxLayout.Y_AXIS));

        addFoodToTrackerView("(food + their macros would go here in a list)");
        addFoodToTrackerView("food1)");
        addFoodToTrackerView("food2)");
    }

    private void addFoodToTrackerView(String foodAndMacros){
        JLabel newFood = new JLabel(foodAndMacros);
        Font font = new Font(newFood.getFont().getFontName(), Font.PLAIN, 20);
        newFood.setFont(font);
        newFood.setHorizontalAlignment(SwingConstants.LEFT);
        putFoodHerePanel.add(newFood);
    }
}
