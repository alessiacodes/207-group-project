package use_case.track;

import entity.Food;
import entity.Tracker;

import java.util.HashMap;

public class TrackInteractor implements TrackInputBoundary {

    final TrackDataAccessInterface trackDataAccessObject;
    final TrackOutputBoundary trackPresenter;

    public TrackInteractor(TrackDataAccessInterface trackDataAccessObject, TrackOutputBoundary trackPresenter) {
        this.trackDataAccessObject = trackDataAccessObject;
        this.trackPresenter = trackPresenter;
    }

    @Override
    public void execute(TrackInputData trackInputData) {
        Tracker tracker = trackInputData.getTracker();
        Food food = trackInputData.getFood();

        // Call Data Access Object to update nutritional values of food
        HashMap<String, Float> nutritionalValues = trackDataAccessObject.getFoodNutritionalValues(food.getName(), food.getQuantity());
        food.setNutritionalValues(nutritionalValues);
//        System.out.println(nutritionalValues);
//        System.out.println(food.getNutritionalValues());

        tracker.addFood(food);
//        System.out.println(tracker.getTotalNutrition());

        TrackOutputData foodOutput = new TrackOutputData(food, tracker);


        if (tracker.getDiary().contains(food)) {
            System.out.println(foodOutput.getTracker() ==  null);
            trackPresenter.prepareSuccessView(foodOutput);
        } else {
            trackPresenter.prepareFailView("Food was not added. Please try again.");
        }
    }
}
