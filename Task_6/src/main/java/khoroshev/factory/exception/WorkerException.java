package khoroshev.factory.exception;

public class WorkerException extends Exception {
    private final String message;

    public WorkerException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
