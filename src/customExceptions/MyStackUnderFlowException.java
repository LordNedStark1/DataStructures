package customExceptions;

public class MyStackUnderFlowException extends RuntimeException {
    public MyStackUnderFlowException(String message) {
        super(message);
    }
}
