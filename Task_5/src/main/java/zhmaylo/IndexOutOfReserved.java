package zhmaylo;

/**
 * Класс IndexOutOfReserved, реализующий checked исключение.
 *
 * @version 1.0
 * @autor Жмайло Василий
 */

class IndexOutOfReserved extends Exception {
    public IndexOutOfReserved(String message) {
        super(message);
    }
}
