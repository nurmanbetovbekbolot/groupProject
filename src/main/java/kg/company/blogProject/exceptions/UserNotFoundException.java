package kg.company.blogProject.exceptions;


public class UserNotFoundException extends Exception{
    private static final String message = "Unable to find user";

    public UserNotFoundException() {
        super(message);
    }
}
