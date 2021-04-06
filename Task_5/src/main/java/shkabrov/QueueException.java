package shkabrov;

/**
 * Класс исключений для очереди
 */
public class QueueException extends Exception {
    private QueueErrorCode queueErrorCode;

    public QueueException(QueueErrorCode queueErrorCode) {
        this.queueErrorCode = queueErrorCode;
    }

    /**
     * @return код ошибки
     */
    public QueueErrorCode getErrorCode() {
        return queueErrorCode;
    }
}
