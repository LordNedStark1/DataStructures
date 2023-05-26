package customExceptions;

public class MyStackOverFlowException extends RuntimeException {
    public MyStackOverFlowException(String message) {
        super(message);
    }
}
