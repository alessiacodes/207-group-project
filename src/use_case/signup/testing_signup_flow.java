//package use_case.signup;
//
//import entity.User;
//import entity.UserFactory;
//
//import java.util.ArrayList;
//
//public class testing_signup_flow {
//
//    public static void main(String[] args) {
//        FakeDAO fakeDAO = new FakeDAO();
//        FakePresenter fakePresenter = new FakePresenter();
//        FakeUserFactory fakeUserFactory = new FakeUserFactory();
//        SignupInteractor interactor = new SignupInteractor(fakeDAO, fakePresenter, fakeUserFactory);
//        SignupController controller = new SignupController(interactor);
//        controller.execute("alessia", "alessia", "alessia", "woman", 19, 160.0, null, 125.0);
//    }
//
//
//}
//class FakePresenter implements SignupOutputBoundary{
//
//    @Override
//    public void prepareSuccessView(SignupOutputData outputData) {
//        System.out.println(outputData.getUsername() + " has signed up successfully!");
//    }
//
//    @Override
//    public void prepareFailView(String error) {
//
//    }
//}
//
//class FakeDAO implements SignupDataAccessInterface{
//
//    @Override
//    public boolean existsByName(String identifier) {
//        return false;
//    }
//
//    @Override
//    public void saveNewUser(User user) {
//        System.out.println("saved :)");
//    }
//}
//
//class FakeUserFactory implements entity.UserFactory{
//
//    @Override
//    public User create(String username, String password, String name, String gender, Float weight, int age, Float height, ArrayList<String> dietaryRestrictions) {
//        entity.BasicUser basicUser = new entity.BasicUser(username, password, name, gender, weight, age, height, dietaryRestrictions);
//        return basicUser;
//    }
//}