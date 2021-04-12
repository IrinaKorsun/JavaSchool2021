package berezin;

public class Queue {

    /**
     * Массив объектов
     */
    private final Object[] array;

    /**
     * Указатель на конец очереди
     */
    private int end;

    /**
     * Констуктор по размеру
     *
     * @param size размер очереди
     */
    public Queue(int size) {
        array = new Object[size];
        end = 0;
    }

    /**
     * Вставляет объект в конец очередь
     * @param value объект для вставки
     * @throws QueueStackException если очередь переполнена
     */
    public void enqueue(Object value) throws QueueStackException {
        if (end == array.length) {
            throw new QueueStackException(ErrorCode.QUEUE_IS_FULL);
        }
        array[end] = value;
        end++;
    }

    /**
     * Удаляет объект из начала очереди
     * @throws QueueStackException если очередь пуста
     */
    public void dequeue() throws QueueStackException {
        if (end == 0) {
            throw new QueueStackException(ErrorCode.QUEUE_IS_EMPTY);
        }
        if (end - 1 >= 0) System.arraycopy(array, 1, array, 0, end - 1);
        array[end - 1] = null;
        end--;
    }

    /**
     * @return true – если очередь пустая, иначе – false
     */
    public boolean isEmpty() {
        return end == 0;
    }

    /**
     * @return первый объект в очереди
     */
    public Object top() {
        return array[0];
    }

}
