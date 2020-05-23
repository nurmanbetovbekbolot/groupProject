package kg.company.blogProject.exceptions;

public class PostNotFoundException extends Exception {
    private static final String message = "Unable to find Post";

    public PostNotFoundException() {
        super(message);
    }
}
