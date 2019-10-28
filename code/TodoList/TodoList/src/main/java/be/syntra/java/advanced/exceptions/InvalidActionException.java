package be.syntra.java.advanced.exceptions;

public class InvalidActionException extends RuntimeException {
    public InvalidActionException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidActionException(String message) {
        super(message);
    }
}
