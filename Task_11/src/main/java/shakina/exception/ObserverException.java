package shakina.exception;

/**
 * Исключение при обнаружении утечки
 */
public class ObserverException extends RuntimeException {

    public ObserverException(String message) {
        super(message);
    }
}