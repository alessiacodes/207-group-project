import data_access.EdamamApiAccess;
import data_access.FileUserDataAccessObject;
import entity.Recommend;
import entity.User;
import use_case.food.*;
import use_case.recommend.*;
import use_case.signup.*;
import view.MainView;
import entity.BasicUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TestingSignup {
    public static void main(String[] args) throws IOException {
        testWithUI();

    }

    public void testWithoutUI(){
        FakeDAO fakeDAO = new FakeDAO();
        FakePresenter fakePresenter = new FakePresenter();
        FakeUserFactory fakeUserFactory = new FakeUserFactory();
        SignupInteractor interactor = new SignupInteractor(fakeDAO, fakePresenter, fakeUserFactory);
        SignupController controller = new SignupController(interactor);
        controller.execute("alessia", "alessia", "alessia", "woman", 19, 160.0, null, 125.0);
    }

    public static void testWithUI() throws IOException {
        FakeUserFactory fakeUserFactory = new FakeUserFactory();
        FakeDAO fakeDAO = new FakeDAO();
        FileUserDataAccessObject fileDAO = new FileUserDataAccessObject("users.csv", fakeUserFactory);
        EdamamApiAccess apiAccess = new EdamamApiAccess();
        

        SignupViewModel signupViewModel = new SignupViewModel();
        SignupPresenter signupPresenter = new SignupPresenter(signupViewModel);
        SignupInteractor signupInteractor = new SignupInteractor(fakeDAO, signupPresenter, fakeUserFactory);
        SignupController signupController = new SignupController(signupInteractor);

        RecommendViewModel recommendViewModel = new RecommendViewModel();
        RecommendPresenter recommendPresenter = new RecommendPresenter(recommendViewModel);
        RecommendInteractor recommendInteractor = new RecommendInteractor(apiAccess, recommendPresenter);
        RecommendController recommendController = new RecommendController(recommendInteractor);

        FoodViewModel foodViewModel = new FoodViewModel();
        FoodPresenter foodPresenter = new FoodPresenter(foodViewModel);
        FoodInteractor foodInteractor = new FoodInteractor(fakeDAO, foodPresenter);
        FoodController foodController = new FoodController(foodInteractor);

        MainView mainView = new MainView(signupViewModel, signupController, recommendViewModel, recommendController, foodViewModel, foodController);
    }
}
class FakePresenter implements SignupOutputBoundary {

    @Override
    public void prepareSuccessView(SignupOutputData outputData) {
        System.out.println(outputData.getUsername() + " has signed up successfully!");
    }

    @Override
    public void prepareFailView(String error) {

    }
}

class FakeDAO implements SignupDataAccessInterface, RecommendDataAccessInterface, FoodDataAccessInterface {

    @Override
    public boolean existsByName(String identifier) {
        return false;
    }

    @Override
    public void saveNewUser(User user) {
        System.out.println("saved :)");
    }

    @Override
    public String getRecommendLink(Recommend identifier) {
        return null;
    }

    @Override
    public HashMap<String, Float> getFoodNutritionalValues(String foodName, Float quantity) {
        HashMap<String, Float> nutritionalValues = new HashMap<String, Float>();
        nutritionalValues.put("Carbs", 10.0f);
        nutritionalValues.put("Protein", 5.0f);
        return nutritionalValues;
    }

    @Override
    public Integer getFoodCalories(String foodName, Float quantity) {
        return 300;
    }
}


class FakeUserFactory implements entity.UserFactory{

    @Override
    public User create(String username, String password, String name, String gender, Double weight, int age, Double height, ArrayList<String> dietaryRestrictions) {
        BasicUser basicUser = new BasicUser(username, password, name, gender, weight, age, height, dietaryRestrictions);
        System.out.println("made user");
        return basicUser;
    }
}
