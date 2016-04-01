package by.bsuir.task4.exception;


public class XMLParserException extends Exception {
    public XMLParserException(Throwable cause) {
        super(cause);
    }

    public XMLParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLParserException(String message) {
        super(message);
    }
}
