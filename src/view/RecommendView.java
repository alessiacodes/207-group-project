package view;

import use_case.recommend.RecommendController;
import use_case.recommend.RecommendState;
import use_case.recommend.RecommendViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RecommendView implements PropertyChangeListener {
    private final RecommendViewModel recommendViewModel;
    private final RecommendController recommendController;
    private final MainView mainView;
    private JPanel recommendViewPanel;
    private JLabel whatAreYourNutritionalLabel;
    private JCheckBox highProteinCheckBox;
    private JCheckBox lowFatCheckBox;
    private JCheckBox highFiberCheckBox;
    private JCheckBox lowCarbCheckBox;
    private JCheckBox lowSodiumCheckBox;
    private ArrayList<JCheckBox> listOfNutritionalNeeds = new ArrayList<>();
    private JLabel title;
    private JCheckBox balancedCheckBox;
    private JCheckBox dairyFreeCheckBox;
    private JCheckBox glutenFreeCheckBox;
    private JCheckBox ketoFriendlyCheckBox;
    private JCheckBox paleoCheckBox;
    private JCheckBox kosherCheckBox;
    private JCheckBox lowSugarCheckBox;
    private JCheckBox pescatarianCheckBox;
    private JCheckBox veganCheckBox;
    private JCheckBox vegetarianCheckBox;
    private ArrayList<JCheckBox> listOfRestrictions = new ArrayList<>();
    private JComboBox mealTypeDropDown;
    private JButton goButton;
    private JButton backButton;

    public RecommendView(MainView mainView, RecommendViewModel recommendViewModel,
                          RecommendController recommendController){
        this.recommendViewModel = recommendViewModel;
        this.recommendController = recommendController;
        this.mainView = mainView;
        recommendViewPanel.setSize(1920,1080);
        setUpPanel();


    }

    public JPanel getRecommendViewPanel() {
        return recommendViewPanel;
    }

    private void setUpPanel(){
        Collections.addAll(listOfNutritionalNeeds, balancedCheckBox, highFiberCheckBox, highProteinCheckBox, lowCarbCheckBox, lowFatCheckBox,lowSodiumCheckBox);
        Collections.addAll(listOfRestrictions, dairyFreeCheckBox, glutenFreeCheckBox, ketoFriendlyCheckBox, kosherCheckBox,lowSugarCheckBox, paleoCheckBox, pescatarianCheckBox, veganCheckBox, vegetarianCheckBox);
        
        mealTypeDropDown.addItem("Breakfast");
        mealTypeDropDown.addItem("Lunch");
        mealTypeDropDown.addItem("Dinner");

        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> stingListofNutritionalNeeds = new ArrayList<>();
                ArrayList<String> stingListofDietaryRestrictions = new ArrayList<>();

                for (JCheckBox nutritionalNeed: listOfNutritionalNeeds) {
                    if (nutritionalNeed.isSelected()){
                        stingListofNutritionalNeeds.add(nutritionalNeed.getText());
                    }
                }

                for (JCheckBox dietaryRestriction: listOfRestrictions) {
                    if (dietaryRestriction.isSelected()){
                        stingListofDietaryRestrictions.add(dietaryRestriction.getText());
                    }
                }

                recommendController.execute(stingListofDietaryRestrictions, stingListofNutritionalNeeds, (String) mealTypeDropDown.getSelectedItem()); //TODO this line will prolly cause issues
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.swapCard(mainView.HOME_SCREEN_PANEL_NAME);
            }
        });
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        RecommendState state = (RecommendState) evt.getNewValue();

        if (state.getCurrentErrorMessage() != null){
            launchFailView(state.getCurrentErrorMessage());
            recommendViewModel.getState().setCurrentErrorMessage(null); // reset so there's no error
        }
        else{ // successfully got link
            launchSuccessView(state.getCurrentSuccessMessage() + " " + state.getRecommendLink());
            state.setRecommendLink("");
            state.setCurrentSuccessMessage(null);

        }
    }
}
