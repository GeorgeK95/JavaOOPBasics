package exceptions;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class InvalidPathException extends RuntimeException {
    private static final String INVALID_PATH = "File does not exist.";

    public InvalidPathException() {
        super(INVALID_PATH);
    }
}
