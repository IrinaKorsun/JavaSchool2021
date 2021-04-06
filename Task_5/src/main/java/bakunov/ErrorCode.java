package bakunov;

public enum ErrorCode {
    IS_FULL("Переполнение"),
    IS_EMPTY("Нет элементов для извлечения");

    private String errorString;

    ErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getMessage() {
        return errorString;
    }
}
