package learn_spring_framework.ade.CustomException;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String userNotFound) {
        super(userNotFound);
    }
}
