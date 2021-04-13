package berezin;

public class QueueStackException extends Exception {

    private ErrorCode errorCode;

    public QueueStackException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public QueueStackException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public QueueStackException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCode errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
