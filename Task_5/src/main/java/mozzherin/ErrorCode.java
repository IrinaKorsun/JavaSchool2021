package mozzherin;

public enum ErrorCode {
    IS_FULL("Is Full"),
    IS_EMPTY("Is Empty");

    private String errorMessage;

    ErrorCode(String errorString) {
        this.errorMessage = errorString;
    }
}

