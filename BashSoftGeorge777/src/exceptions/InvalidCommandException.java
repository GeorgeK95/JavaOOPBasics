package exceptions;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class InvalidCommandException extends RuntimeException {

    public InvalidCommandException(String command) {
        super(String.format("The command '%s' is invalid.", command));
    }
}
