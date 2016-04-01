package by.bsuir.airline.exception;

/**
 * Created by Maria Teseiko on 01.12.2015.
 */
public class AirlineParserException extends Exception {
    public AirlineParserException() {
    }

    public AirlineParserException(String message) {
        super(message);
    }

    public AirlineParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public AirlineParserException(Throwable cause) {
        super(cause);
    }
}
