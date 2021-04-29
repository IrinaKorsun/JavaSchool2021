package shkabrov;

/**
 * Коды ошибок LibraryForCodeTesting
 */
public enum LibraryForCodeTestingErrorCode {
    WRONG_NUMBER_OF_METHODS_WITH_DO_AFTER_ALL_ANNOTATION("There must be one method with the annotation" +
            " \"DoAfterAll\""),
    WRONG_NUMBER_OF_METHODS_WITH_DO_BEFORE_ALL_ANNOTATION("There must be one method with the annotation" +
            " \"DoBeforeAll\"");

    private String errorString;

    LibraryForCodeTestingErrorCode(String errorString) {
        this.errorString = errorString;
    }

    /**
     * @return текст ошибки
     */
    public String getErrorString() {
        return errorString;
    }
}
