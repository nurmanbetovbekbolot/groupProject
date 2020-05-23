package kg.company.blogProject.exception;

public class UserNotFoundException extends Exception {
    final static String message = "User not found";

    public UserNotFoundException() {
        super(message);
    }
}
