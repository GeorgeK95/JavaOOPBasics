package app.entities.exceptions;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class UnableToPayBillsException extends RuntimeException {
    private static final String MESSAGE = "Can't pay the bills. Bye.";

    public UnableToPayBillsException() {
        super(MESSAGE);
    }
}
