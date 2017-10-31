package exceptions;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class DataAlreadyInitializedException extends RuntimeException{
    private static final String DATA_ALREADY_INITIALIZED = "Data was already initialized.";

    public DataAlreadyInitializedException() {
        super(DATA_ALREADY_INITIALIZED);
    }
}
