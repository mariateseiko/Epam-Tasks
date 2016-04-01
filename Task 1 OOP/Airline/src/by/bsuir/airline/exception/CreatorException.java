package by.bsuir.airline.exception;

/**
 * Created by Maria Teseiko on 25.11.2015.
 */
public class CreatorException extends Exception {

    public CreatorException() {}

    public CreatorException(String message) {
        super(message);
    }

    public CreatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreatorException(Throwable cause) {
        super(cause);
    }
}
