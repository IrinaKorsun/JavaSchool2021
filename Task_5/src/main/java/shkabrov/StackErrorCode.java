package shkabrov;

/**
 * Перечисление кодов ошибок для стека
 */
public enum StackErrorCode {
    STACK_INCORRECT_SIZE("Cannot set the maximum number of stack items to zero"),
    STACK_INSUFFICIENT_SIZE("Exceeded the maximum number of elements"),
    STACK_MAX_SIZE_EXCEEDED("Maximum allowed stack size exceeded"),
    STACK_FULL("No space to insert another element"),
    STACK_EMPTY("No elements to retrieve"),
    STACK_NULL_ELEMENT("Cannot add \"null\" to the stack ");

    private String errorString;

    StackErrorCode(String errorString) {
        this.errorString = errorString;
    }

    /**
     * @return текст ошибки
     */
    public String getErrorString() {
        return errorString;
    }
}
