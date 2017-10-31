package exceptions;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class InvalidStringException extends RuntimeException {
    private static final String NULL_OR_EMPTY_VALUE = "The value of the variable CANNOT be null or empty!";

    public InvalidStringException() {
        super(NULL_OR_EMPTY_VALUE);
    }
}
