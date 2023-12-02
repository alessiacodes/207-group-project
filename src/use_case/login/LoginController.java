package use_case.login;

import entity.Food;
import use_case.recipe.RecipeInputBoundary;
import use_case.recipe.RecipeInputData;

import java.util.LinkedHashMap;

public class LoginController {
    final LoginInputBoundary interactor;

    public LoginController(LoginInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String username, String password){
        LoginInputData inputData = new LoginInputData(username, password);
        interactor.execute(inputData);
    }
}
