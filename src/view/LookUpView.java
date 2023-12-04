package view;

import use_case.food.FoodController;
import use_case.food.FoodState;
import use_case.food.FoodViewModel;
import use_case.track.TrackController;
import use_case.track.TrackViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;
import java.util.Objects;

public class LookUpView implements PropertyChangeListener {
    private JPanel lookUpViewPanel;
    private JButton getNutritionButton;
    private JTextField quantityTextField;
    private JTextField unitTextField;
    private JTextField foodNameTextField;
    private JButton addToTrackerButton;
    private JButton backButton;
    private final MainView mainView;
    private final FoodViewModel foodViewModel;
    private final FoodController foodController;
    private final TrackViewModel trackViewModel;
    private final TrackController trackController;

    public LookUpView(MainView mainView, FoodViewModel foodViewModel, FoodController foodController, TrackViewModel trackViewModel, TrackController trackController) {
        this.mainView = mainView;
        this.foodViewModel = foodViewModel;
        this.foodController = foodController;
        this.trackViewModel = trackViewModel;
        this.trackController = trackController;

        setUpPanel();

    }

    public JPanel getLookupPanel() {
        return lookUpViewPanel;
    }

    private void setUpPanel(){
        foodViewModel.addPropertyChangeListener(this);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.swapCard(mainView.HOME_SCREEN_PANEL_NAME);
            }
        });
        getNutritionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Float quantity = Float.parseFloat(quantityTextField.getText());
                    if (unitTextField.getText() == null || foodNameTextField.getText() == null){
                        launchFailView("Error: text field left blank");
                    }
                    String foodName = unitTextField.getText() + " " + foodNameTextField.getText();
                    foodController.execute(foodName, quantity);
                } catch(NumberFormatException error){
                    launchFailView("Please enter a number quantity");
                }

            }
        });
        addToTrackerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trackViewModel.addPropertyChangeListener(mainView.getHomeScreenView());
                try {
                    Float quantity = Float.parseFloat(quantityTextField.getText());
                    if (unitTextField.getText() == null || foodNameTextField.getText() == null){
                        launchFailView("Error: text field left blank");
                    }
                    String foodName = unitTextField.getText() + " " + foodNameTextField.getText();
                    trackController.execute(foodName, quantity.toString());
                } catch(NumberFormatException error){
                    launchFailView("Please enter a number quantity");
                }
            }
        });
    }

    public void launchSuccessView(FoodState state){

        JFrame successPopUpWindow = new JFrame();
        successPopUpWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        successPopUpWindow.setTitle("Success: Food Found!");
        successPopUpWindow.setSize(600,500);

        JPanel newPanel = new JPanel();

        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
        newPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        successPopUpWindow.add(newPanel);

        JLabel foodTitle = new JLabel();
        foodTitle.setText(state.getQuantity() +" "+ state.getFoodName());
        foodTitle.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = foodTitle.getFont();
        foodTitle.setFont(new Font(font.getName(), Font.BOLD, 30));
        newPanel.add(foodTitle);

        JLabel calories = new JLabel();
        calories.setText("Calories: " + state.getkCal());
        calories.setHorizontalAlignment(SwingConstants.CENTER);
        calories.setFont(new Font(font.getName(), Font.PLAIN, 30));
        newPanel.add(calories);

        for (Map.Entry<String, Float> nutrition: state.getNutritionalValues().entrySet()) {
            if (!Objects.equals(nutrition.getKey(), "Calories")) {
                JLabel nutritionLabel = new JLabel();
                nutritionLabel.setText(nutrition.getKey() + ": " + nutrition.getValue());
                nutritionLabel.setHorizontalAlignment(SwingConstants.CENTER);
                nutritionLabel.setFont(new Font(font.getName(), Font.PLAIN, 30));
                newPanel.add(nutritionLabel);
            }
        }




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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        FoodState state = (FoodState) evt.getNewValue();
        launchSuccessView(state);
        
    }
}
