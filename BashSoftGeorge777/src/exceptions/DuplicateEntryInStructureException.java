package exceptions;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class DuplicateEntryInStructureException extends RuntimeException {
    public static final String DUPLICATE_ENTRY = "The %s already exists in %s.";

    public DuplicateEntryInStructureException(String entryName, String structureName) {
        super(String.format(DUPLICATE_ENTRY, entryName, structureName));
    }
}
