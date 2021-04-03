package shakina.exception;

public class MyException extends Exception {
    private final ErrorCode errorCode;

    public MyException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode gerErrorCode() {
        return errorCode;
    }
}
