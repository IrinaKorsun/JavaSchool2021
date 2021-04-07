package starikov;

public class StackAndQueueException extends RuntimeException {
    private String exceptionMessage;

    public StackAndQueueException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String toString() {
        return "StackAndQueueException: " + exceptionMessage;
    }
}
