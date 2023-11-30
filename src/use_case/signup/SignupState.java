package use_case.signup;

public class SignupState {

    // Attributes for popups
    private String username = "";
    private String currentErrorMessage = null;
    private String currentSuccessMessage = null;

    // TODO do we need this to make a copy?
    public SignupState(SignupState copy) {
        username = copy.username;
        currentErrorMessage = copy.currentErrorMessage;
        currentSuccessMessage = copy.currentSuccessMessage;
    }

    public SignupState(){

    }

    public String getUsername() {
        return username;
    }

    public String getCurrentErrorMessage() {
        return currentErrorMessage;
    }

    public String getCurrentSuccessMessage() {
        return currentSuccessMessage;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCurrentErrorMessage(String currentErrorMessage) {
        this.currentErrorMessage = currentErrorMessage;
    }

    public void setCurrentSuccessMessage(String currentSuccessMessage) {
        this.currentSuccessMessage = currentSuccessMessage;
    }


}
