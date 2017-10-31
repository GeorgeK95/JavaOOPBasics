package exceptions;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class InvalidFilterException extends RuntimeException {
    private static final String INVALID_FILTER = "Invalid filter.";

    public InvalidFilterException() {
        super(INVALID_FILTER);
    }
}
