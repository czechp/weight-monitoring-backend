package app.web.exception;

public class NotEnoughPrivilegesException extends RuntimeException {
    public NotEnoughPrivilegesException(String message) {
        super(message);
    }
}
