package be.syntra.java.advanced.exceptions;

public class InvalidConfirmationException extends RuntimeException {
    public InvalidConfirmationException(String message, Throwable cause) {
        super(message, cause);
    }
}
