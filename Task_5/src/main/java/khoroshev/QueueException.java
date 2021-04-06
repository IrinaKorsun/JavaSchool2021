package khoroshev;

public class QueueException extends Exception {
    private final String message;

    public QueueException(String message) {
        this.message = message;
    }
}
