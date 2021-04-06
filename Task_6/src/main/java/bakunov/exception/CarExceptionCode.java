package bakunov.exception;

public enum CarExceptionCode {
    UNKNOWN_MODEL("Неизвестная модель авто"),
    UNKNOWN_ENGINE("Неизвестный двигатель");

    private String errorString;

    CarExceptionCode(String errorString) {
        this.errorString = errorString;
    }

    public String getMessage() {
        return errorString;
    }
}
