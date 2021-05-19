package khoroshev.exception;

public class AnnotateException extends Exception{
    private final String message;

    public AnnotateException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
