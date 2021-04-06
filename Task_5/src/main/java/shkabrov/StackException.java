package shkabrov;

/**
 * Класс исключений для стека
 */
public class StackException extends Exception {
    private StackErrorCode stackErrorCode;

    public StackException(StackErrorCode stackErrorCode) {
        this.stackErrorCode = stackErrorCode;
    }

    /**
     * @return код ошибки
     */
    public StackErrorCode getErrorCode() {
        return stackErrorCode;
    }
}
