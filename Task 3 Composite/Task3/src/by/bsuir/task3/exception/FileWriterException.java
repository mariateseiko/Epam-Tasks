package by.bsuir.task3.exception;

public class FileWriterException extends Exception {
    public FileWriterException(String message) {
        super(message);
    }

    public FileWriterException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileWriterException() {
        super();
    }

    public FileWriterException(Throwable cause) {
        super(cause);
    }
}
