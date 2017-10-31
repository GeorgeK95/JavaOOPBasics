package exceptions;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class KeyNotFoundException extends RuntimeException {
    private static final String NOT_ENROLLED_IN_COURSE = "Invalid course.";

    public KeyNotFoundException() {
        super(NOT_ENROLLED_IN_COURSE);
    }
}
