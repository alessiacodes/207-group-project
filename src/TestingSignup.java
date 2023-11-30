import data_access.FileUserDataAccessObject;
import entity.User;
import use_case.signup.*;
import view.MainView;
import entity.BasicUser;

import java.io.IOException;
import java.util.ArrayList;

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
        SignupViewModel signupViewModel = new SignupViewModel();
//        FakeDAO fakeDAO = new FakeDAO();
        SignupPresenter signupPresenter = new SignupPresenter(signupViewModel);
        FakeUserFactory fakeUserFactory = new FakeUserFactory();
        FileUserDataAccessObject realDAO = new FileUserDataAccessObject("users.csv", fakeUserFactory);
        SignupInteractor signupInteractor = new SignupInteractor(realDAO, signupPresenter, fakeUserFactory);
        SignupController signupController = new SignupController(signupInteractor);
        MainView mainView = new MainView(signupViewModel, signupController);
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

class FakeDAO implements SignupDataAccessInterface {

    @Override
    public boolean existsByName(String identifier) {
        return false;
    }

    @Override
    public void saveNewUser(User user) {
        System.out.println("saved :)");
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
