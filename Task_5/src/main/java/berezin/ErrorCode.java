package berezin;

public enum ErrorCode {
    QUEUE_IS_FULL("Очередь переполнена"),
    QUEUE_IS_EMPTY("Очередь пуста"),
    STACK_IS_FULL("Стек переполнен"),
    STACK_IS_EMPTY("Стек пуст");

    private final String errorString;

    private ErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
