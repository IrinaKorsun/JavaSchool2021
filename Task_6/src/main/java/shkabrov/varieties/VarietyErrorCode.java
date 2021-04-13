package shkabrov.varieties;

/**
 * Коды ошибок для VarietyException
 */
public enum VarietyErrorCode {
    VARIETY_INCORRECT("Cannot set this variety");

    private String errorString;

    VarietyErrorCode(String errorString) {
        this.errorString = errorString;
    }

    /**
     * @return текст ошибки
     */
    public String getErrorString() {
        return errorString;
    }
}
