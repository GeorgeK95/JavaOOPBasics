package exceptions;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class InvalidFileNameException extends RuntimeException {
    private static final String FORBIDDEN_SYMBOLS_CONTAINED_IN_NAME = "Forbidden symbols contained in name.";

    public InvalidFileNameException() {
        super(FORBIDDEN_SYMBOLS_CONTAINED_IN_NAME);
    }
}
