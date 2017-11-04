package exceptions;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String line) {
        super(String.format("The command %s is invalid.", line));
    }
}
