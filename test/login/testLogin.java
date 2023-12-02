package login;

import data_access.FileUserDataAccessObject;
import entity.User;
import use_case.login.*;
import view.MainView;
import entity.BasicUser;

import java.io.IOException;
import java.util.ArrayList;

public class testLogin {
    public static void main(String[] args) throws IOException {
        testWithoutUI();

    }

    public static void testWithoutUI() {
        FakeDAO fakeDAO = new FakeDAO();
        FakePresenter fakePresenter = new FakePresenter();
        LoginInteractor interactor = new LoginInteractor(fakeDAO, fakePresenter);
        LoginController controller = new LoginController(interactor);
        controller.execute("alessia", "alessia");
    }
}

class FakePresenter implements LoginOutputBoundary {

    @Override
    public void prepareSuccessView(LoginOutputData outputData) {
        System.out.println(outputData.getUsername() + " has logged in successfully!");
    }

    @Override
    public void prepareFailView(String error) {

    }
}

class FakeDAO implements LoginUserDataAccessInterface {

    @Override
    public boolean existsByName(String identifier) {
        return true;
    }

    @Override
    public void saveNewUser(User user) {
        System.out.println("saved :)");
    }

    @Override
    public User get(String username) { return ...; }
}


