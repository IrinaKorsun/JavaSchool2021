package mozzherin;

public class Queue {
    private final int MAX_ARRAY_SIZE = 1000;

    private Object[] array = new Object[MAX_ARRAY_SIZE];
    private int size = 0;

    /**
     * Метод добавляет новый элемент в Queue
     * @param element - добавляемый элемент
     * @return в случае успешного добавления возвращает true
     * @throws QueueStackException
     */
    public boolean enqueue(Object element) throws QueueStackException{
        if (size >= MAX_ARRAY_SIZE) {
            throw new QueueStackException(ErrorCode.IS_FULL);
        }
        array[size] = element;
        size++;
        return true;
    }

    /**
     * Метод удаляет верхний элемент в Queue
     * @return в случае успешного удаления возвращает true
     * @throws QueueStackException
     */
    public boolean dequeue() throws QueueStackException {
        if (size == 0) {
            throw new QueueStackException(ErrorCode.IS_EMPTY);
        } else {
            for (int i = 0; i < size; i++) {
                array[i] = array[i + 1];
            }
            array[size] = null;
            size--;
        }
        return true;
    }

    /**
     * Метод возвращает значение true/false в зависимости, от того является ли очередь пустой
     */
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    /**
     * возвращает ерхний эелемент из очереди
     */
    public Object top() throws QueueStackException {
        if (size == 0) {
            throw new QueueStackException(ErrorCode.IS_EMPTY);
        }
        return array[0];
    }

    /**
     * Метод возвращает размер очереди
     * @return - размер Queue
     */
    public int getSize() {
        return size;
    }
}