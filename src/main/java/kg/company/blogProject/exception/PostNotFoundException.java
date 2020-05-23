package kg.company.blogProject.exception;

public class PostNotFoundException extends Exception {
    final static String message = "Post not found";

    public PostNotFoundException() {
        super(message);
    }
}
