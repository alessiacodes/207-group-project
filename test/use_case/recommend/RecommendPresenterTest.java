package use_case.recommend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecommendPresenterTest {

    private final String successMessage = "Here is your recipe recommendation: http://www.edamam.com/recipe/ 💚";

    // create objects needed to run presenter prepareSuccessView and prepareFailView
    private RecommendViewModel recommendViewModel = new RecommendViewModel();

    private RecommendOutputData recommendOutputData = new RecommendOutputData("http://www.edamam.com/recipe/");

    private RecommendPresenter recommendPresenter = new RecommendPresenter(recommendViewModel);


    @Test
    public void prepareSuccessView() {

        RecommendState recommendState = recommendViewModel.getState();
        // call method using fake output data
        recommendPresenter.prepareSuccessView(recommendOutputData);

        // check that prepareSuccessView updates state and viewModel correctly
        assertEquals(recommendOutputData.getRecommendLink(), recommendViewModel.getState().getRecommendLink());
        assertEquals(successMessage, recommendViewModel.getState().getCurrentSuccessMessage());
        assertEquals(recommendState, recommendViewModel.getState());
    }

    @Test
    public void prepareFailView() {
        RecommendState recommendState = recommendViewModel.getState();
        recommendPresenter.prepareFailView("RuntimeException");
        assertEquals(recommendState, recommendViewModel.getState());
    }
}