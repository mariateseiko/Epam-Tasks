package by.bsuir.task2.exception;

public class ParkingNetworkParserException extends Exception {
    public ParkingNetworkParserException() {
        super();
    }

    public ParkingNetworkParserException(String message) {
        super(message);
    }

    public ParkingNetworkParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingNetworkParserException(Throwable cause) {
        super(cause);
    }
}
