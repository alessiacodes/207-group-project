package use_case.food;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class FoodPresenterTest {

    //    Creating objects needed to run presenter

    private FoodViewModel foodViewModel = new FoodViewModel();
    private FoodOutputData foodOutputData = new FoodOutputData(
            "apple",
            1.0f,
            new HashMap<>(),
            10
    );
    private FoodPresenter foodPresenter = new FoodPresenter(foodViewModel);
    @Test
    public void prepareSuccessView() {

        FoodState foodState = foodViewModel.getState();
        //        Calling method using fake output data
        foodPresenter.prepareSuccessView(foodOutputData);

//        Checking that successView updates state and viewModel correctly
        assertEquals(foodOutputData.getFoodName(), foodViewModel.getState().getFoodName());
        assertEquals(foodOutputData.getKcal(), foodViewModel.getState().getkCal());
        assertEquals(foodOutputData.getQuantity(), foodViewModel.getState().getQuantity(), 0.01);
        assertEquals(foodOutputData.getNutritionalValues(), foodViewModel.getState().getNutritionalValues());
        assertEquals(foodState, foodViewModel.getState());
    }

    @Test
    public void prepareFailView() {
        FoodState foodState = foodViewModel.getState();
        foodPresenter.prepareFailView("RunTimeException");
        assertEquals(foodState, foodViewModel.getState());
    }
}