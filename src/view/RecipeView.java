package view;

import use_case.recipe.RecipeController;
import use_case.recipe.RecipeState;
import use_case.recipe.RecipeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.List;

public class RecipeView implements PropertyChangeListener {
    private final MainView mainView;
    private final RecipeController recipeController;
    private final RecipeViewModel recipeViewModel;
    private JPanel mainPanel;
    private JPanel holderPanel = new JPanel();
    private JButton submitButton = new JButton();
    private JButton addButton = new JButton();
    private JButton backButton = new JButton();
    private ArrayList<JTextField> textFields;

    public RecipeView(MainView mainView, RecipeController recipeController, RecipeViewModel recipeViewModel){
        this.mainView = mainView;
        this.recipeController = recipeController;
        this.recipeViewModel = recipeViewModel;
        setUpPanel();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void setUpPanel() {
        recipeViewModel.addPropertyChangeListener(this);

        mainPanel.setLayout(new FlowLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // NOTE: add comps to the holder panel, NOT the main panel
        holderPanel.setLayout(new BoxLayout(holderPanel, BoxLayout.Y_AXIS));
        holderPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        holderPanel.setPreferredSize(new Dimension( 1900,1000));

        JScrollPane scrollFrame = new JScrollPane(holderPanel);
        holderPanel.setAutoscrolls(true);
        scrollFrame.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollFrame.getViewport().setPreferredSize(new Dimension( 1900,1000));
        mainPanel.add(scrollFrame);
        scrollFrame.getViewport().add(holderPanel,null);
        Font font = backButton.getFont();

        // panel.setPreferredSize(new Dimension(512,448));
//        JScrollPane scrollPane = new JScrollPane(holderPanel);
//        scrollPane.getViewport().setPreferredSize(new Dimension(1000, 1000));
//
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        mainPanel.add(scrollPane);

        backButton.setText("Back");
        backButton.setFont(new Font(font.getName(), Font.BOLD, 20));
        backButton.setBackground(Color.decode("#5BBF73"));
        holderPanel.add(backButton);

        JLabel title = new JLabel();
        title.setText("Calculate Calories in Recipe");
        title.setFont(new Font(font.getName(), Font.BOLD, 35));
        title.setForeground(Color.decode("#5BBF73"));
        holderPanel.add(title);

        submitButton.setText("Submit");
        submitButton.setFont(new Font(font.getName(), Font.BOLD, 20));
        submitButton.setBackground(Color.decode("#5BBF73"));

        JLabel swingMessage = new JLabel();
        swingMessage.setText("Note: Due to a bug with Java Swing, please scroll down after every new ingredient added.");
        swingMessage.setFont(new Font(font.getName(), Font.BOLD, 16));
        swingMessage.setForeground(Color.darkGray);
        holderPanel.add(swingMessage);

        addButton.setText("Add another Ingredient");
        addButton.setFont(new Font(font.getName(), Font.BOLD, 20));
        addButton.setBackground(Color.decode("#5BBF73"));

        holderPanel.add(submitButton);
        holderPanel.add(addButton);

        JLabel recipeLabel = new JLabel();
        JTextField recipeField = new JTextField();

        recipeLabel.setText("Recipe Name");
        recipeLabel.setFont(new Font(font.getName(), Font.BOLD, 20));
        recipeLabel.setForeground(Color.BLACK);
        holderPanel.add(recipeLabel);

        recipeField.setFont(new Font(font.getName(), Font.PLAIN, 20));
        recipeField.setMaximumSize(new Dimension(500,30));
        holderPanel.add(recipeField);

        textFields = addNewIngredient();

        LinkedHashMap<List<String>, Integer> ingredients = new LinkedHashMap<>();


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> ingridientsList = new ArrayList<>();
                ingridientsList.add(textFields.get(1).getText() + " " + textFields.get(2).getText());
                ingridientsList.add(textFields.get(0).getText());

                ingredients.put(ingridientsList, 1);
                System.out.println(ingredients);
                recipeController.execute(recipeField.getText(), ingredients);

            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> ingridientsList = new ArrayList<>();
                ingridientsList.add(textFields.get(1).getText() + " " + textFields.get(2).getText());
                ingridientsList.add(textFields.get(0).getText());

                ingredients.put(ingridientsList, 1);

                textFields = addNewIngredient();


            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.swapCard(mainView.HOME_SCREEN_PANEL_NAME);

            }
        });


    }

    private ArrayList<JTextField> addNewIngredient(){
        System.out.println("back here!");
        JLabel quantityLabel = new JLabel();
        JTextField quantityField = new JTextField();
        JLabel unitsLabel = new JLabel();
        JTextField unitsField = new JTextField();
        JLabel nameLabel = new JLabel();
        JTextField nameField = new JTextField();

        Font font = quantityLabel.getFont();


        quantityLabel.setText("Quantity");
        quantityLabel.setFont(new Font(font.getName(), Font.BOLD, 20));
        quantityLabel.setForeground(Color.BLACK);
        holderPanel.add(quantityLabel);

        quantityField.setFont(new Font(font.getName(), Font.PLAIN, 20));
        quantityField.setMaximumSize(new Dimension(500,30));
        holderPanel.add(quantityField);


        unitsLabel.setText("Units");
        unitsLabel.setFont(new Font(font.getName(), Font.BOLD, 20));
        unitsLabel.setForeground(Color.BLACK);
        holderPanel.add(unitsLabel);

        unitsField.setFont(new Font(font.getName(), Font.PLAIN, 20));
        unitsField.setMaximumSize(new Dimension(500,30));
        holderPanel.add(unitsField);

        nameLabel.setText("Name");
        nameLabel.setFont(new Font(font.getName(), Font.BOLD, 20));
        nameLabel.setForeground(Color.BLACK);
        holderPanel.add(nameLabel);

        nameField.setFont(new Font(font.getName(), Font.PLAIN, 20));
        nameField.setMaximumSize(new Dimension(500,30));
        holderPanel.add(nameField);

        ArrayList<JTextField> textFields = new ArrayList<>();
        textFields.add(quantityField);
        textFields.add(unitsField);
        textFields.add(nameField);

        return textFields;
    }

    private void launchSuccessView(RecipeState state){

        JFrame successPopUpWindow = new JFrame();
        successPopUpWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        successPopUpWindow.setTitle("Success: Recipe Analyzed");
        successPopUpWindow.setSize(600,500);

        JPanel newPanel = new JPanel();

        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
        newPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        successPopUpWindow.add(newPanel);

        JLabel foodTitle = new JLabel();
        foodTitle.setText(state.getRecipeName());
        foodTitle.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = foodTitle.getFont();
        foodTitle.setFont(new Font(font.getName(), Font.BOLD, 30));
        newPanel.add(foodTitle);

        JLabel calories = new JLabel();
        calories.setText("Calories: " + state.getkCal());
        calories.setHorizontalAlignment(SwingConstants.CENTER);
        calories.setFont(new Font(font.getName(), Font.PLAIN, 30));
        newPanel.add(calories);

        for (Map.Entry<String, Float> nutrition: state.getTotalNutrients().entrySet()) {
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        RecipeState state = (RecipeState) evt.getNewValue();
        launchSuccessView(state);
    }
}

