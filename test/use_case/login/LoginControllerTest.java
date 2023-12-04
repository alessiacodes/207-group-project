package use_case.login;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginControllerTest {

    private FakeLoginInputBoundary interactor = new FakeLoginInputBoundary();

    @Test
    public void execute() {
        LoginInputData expected = new LoginInputData("Marvn", "fitness!");

        LoginController controller = new LoginController(interactor);
        controller.execute("Marvn", "fitness!");

        assertEquals(expected.getUsername(), interactor.getLastInput().getUsername());
        assertEquals(expected.getPassword(), interactor.getLastInput().getPassword());
    }

    private static class FakeLoginInputBoundary implements LoginInputBoundary {
        private LoginInputData lastInput;

        @Override
        public void execute(LoginInputData input) {lastInput = input;}

        public LoginInputData getLastInput() {return lastInput;}
    }

}