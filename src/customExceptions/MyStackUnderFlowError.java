package customExceptions;

public class MyStackUnderFlowError extends RuntimeException {
    public MyStackUnderFlowError(String message) {
        super(message);
    }
}
