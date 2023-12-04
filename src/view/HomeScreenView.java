package view;

import use_case.recommend.RecommendController;
import use_case.recommend.RecommendState;
import use_case.recommend.RecommendViewModel;
import use_case.track.TrackState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

public class HomeScreenView implements PropertyChangeListener {
    private final MainView mainView;
    private JPanel homeScreenPanel;
    private JLabel logoImageLabel;
    private JPanel leftTrackerSpacePanel;
    private JPanel trackerTextPanel;
    private JLabel TrackerTitle;
    private JPanel totalMarcosPanel;
    private JPanel putFoodHerePanel;
    private JPanel titleAndButtonsPanel;

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
        calculateCaloriesInRecipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.swapCard(mainView.RECIPE_VIEW_PANEL_NAME);
            }
        });
        recommendARecipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.swapCard(mainView.RECOMMEND_PANEL_NAME);
            }
        });
        lookUpFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.swapCard(mainView.LOOKUP_VIEW_PANEL_NAME);
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

    public void launchSuccessView(String successMessage){
        JFrame successPopUpWindow = new JFrame();
        successPopUpWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        successPopUpWindow.setTitle("Success: food added!");
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

    private void updateTotalMacros(Double totalCals, float totalCarbs, float totalFat, float totalProtein){
        totalCaloriesLabel.setText("Total Calories: "+ totalCals);
        totalCarbsLabel.setText("Total Carbs: "+ totalCarbs);
        totalFatLabel.setText("Total Fat: "+ totalFat);
        totalProteinLabel.setText("Total Protein: "+ totalProtein);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        mainView.swapCard(mainView.HOME_SCREEN_PANEL_NAME);

        TrackState state = (TrackState) evt.getNewValue();
        HashMap<String, Float> totalNutrition = state.getTracker().getTotalNutrition();
        updateTotalMacros(state.getTracker().getTotalCalories().doubleValue(),
                totalNutrition.get("Carbs"),
                totalNutrition.get("Fat"),
                totalNutrition.get("Protein")
                );
        System.out.println("here!");
        addFoodToTrackerView(state.getFood().getQuantity() + " "+ state.getFood().getName() + ": " + // TODO fix null pointer exception, doesn't actually cause a crash tho
                 state.getFood().getCalories() + " KCal / " +
                 state.getFood().getCarbs() + " Carbs / " +
                 state.getFood().getFat() +  " Fat / " +
                 state.getFood().getProtein()+ " Protein ") ;

        launchSuccessView("Successfully added " + state.getFood().getQuantity() +" "+ state.getFood().getName());

        state.setFood(null);
        state.setNutritionalValues(null);
    }
}
