package app.web.exception;

public class TestCannotExecuteException extends RuntimeException {
    public TestCannotExecuteException(String message) {
        super(message);
    }
}
