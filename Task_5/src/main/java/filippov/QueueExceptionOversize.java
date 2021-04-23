package filippov;

//  Обработка исключения через свой класс
public class QueueExceptionOversize extends Exception {
    public QueueExceptionOversize(String message) {
        super(message);
    }
}