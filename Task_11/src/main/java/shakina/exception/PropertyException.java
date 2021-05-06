package shakina.exception;

/**
 * Исключение при обработке файла .properties
 */
public class PropertyException extends RuntimeException {

    public PropertyException(String message) {
        super(message);
    }
}