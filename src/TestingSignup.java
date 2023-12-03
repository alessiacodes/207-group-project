import data_access.EdamamApiAccess;
import data_access.FileUserDataAccessObject;
import entity.Food;
import entity.Recommend;
import entity.User;
import use_case.food.*;
import use_case.login.*;
import use_case.recommend.*;
import use_case.signup.*;
import use_case.track.*;
import view.MainView;
import entity.BasicUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        RecommendInteractor recommendInteractor = new RecommendInteractor(fakeDAO, recommendPresenter);
        RecommendController recommendController = new RecommendController(recommendInteractor);

        FoodViewModel foodViewModel = new FoodViewModel();
        FoodPresenter foodPresenter = new FoodPresenter(foodViewModel);
        FoodInteractor foodInteractor = new FoodInteractor(fakeDAO, foodPresenter);
        FoodController foodController = new FoodController(foodInteractor);

        TrackState trackState = new TrackState();
        TrackViewModel trackViewModel = new TrackViewModel(trackState);
        TrackPresenter trackPresenter = new TrackPresenter(trackViewModel);
        TrackInteractor trackInteractor = new TrackInteractor(fakeDAO, trackPresenter);
        TrackController trackController = new TrackController(trackInteractor);

        LoginViewModel loginViewModel = new LoginViewModel();
        LoginPresenter loginPresenter = new LoginPresenter(loginViewModel);
        LoginInteractor loginInteractor = new LoginInteractor(fakeDAO, loginPresenter);
        LoginController loginController = new LoginController(loginInteractor);

        MainView mainView = new MainView(signupViewModel, signupController, recommendViewModel, recommendController, foodViewModel, foodController, trackViewModel, trackController, loginViewModel, loginController);
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

class FakeDAO implements SignupDataAccessInterface, RecommendDataAccessInterface, FoodDataAccessInterface, TrackDataAccessInterface, LoginUserDataAccessInterface {

    @Override
    public boolean existsByName(String identifier) {
        return true;
    }

    @Override
    public void saveNewUser(User user) {
        System.out.println("saved :)");
    }

    @Override
    public User get(String username) {
        return new BasicUser("alessia", "ruberto", "Alessia Ruberto", null, null, 19, null, null);
    }

    @Override
    public String getRecommendLink(Recommend identifier) {
        return null;
    }

    @Override
    public HashMap<String, Double> getFoodNutritionalValues(String foodName, Float quantity) {
        HashMap<String, Double> nutritionalValues = new HashMap<String, Double>();
        nutritionalValues.put("Carbs", 10.0);
        nutritionalValues.put("Protein", 5.0);
        return nutritionalValues;
    }

    @Override
    public Integer getFoodCalories(String foodName, Float quantity) {
        return 300;
    }

    @Override
    public List<Food> getFoodDiary() {
        return null;
    }

    @Override
    public void addFoodEntry(Food foodEntry) {

    }

    @Override
    public void updateFoodEntry(String updatedFoodEntry, float newAmount) {

    }

    @Override
    public void removeFood(Food foodEntry) {

    }

    @Override
    public Map<String, Float> getTotalNutrition() {
        return null;
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
