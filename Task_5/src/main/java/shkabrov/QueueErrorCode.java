package shkabrov;

/**
 * Перечисление кодов ошибок для очереди
 */
public enum QueueErrorCode {
    // Каждый элемент перечисления - экземпляр класса, вызывается конструктор для инициализации поля errorString
    QUEUE_INCORRECT_SIZE("Cannot set the maximum number of queue items to zero"),
    QUEUE_INSUFFICIENT_SIZE("Exceeded the maximum number of elements"),
    QUEUE_MAX_SIZE_EXCEEDED("Maximum allowed queue size exceeded"),
    QUEUE_FULL("No space to insert another element"),
    QUEUE_EMPTY("No elements to retrieve"),
    QUEUE_NULL_ELEMENT("Cannot add \"null\" to the queue ");

    private String errorString;

    QueueErrorCode(String errorString) {
        this.errorString = errorString;
    }

    /**
     * @return текст ошибки
     */
    public String getErrorString() {
        return errorString;
    }
}
