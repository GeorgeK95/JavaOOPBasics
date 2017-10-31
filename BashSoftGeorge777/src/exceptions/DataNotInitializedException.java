package exceptions;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class DataNotInitializedException extends RuntimeException{
    private static final String DATA_NOT_INITIALIZED = "Data was already initialized.";


    public DataNotInitializedException() {
        super(DATA_NOT_INITIALIZED);
    }
}
